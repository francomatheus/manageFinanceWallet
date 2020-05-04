package br.com.manageFinanceWallet.Resource;

import br.com.manageFinanceWallet.Entity.OperationEntity;
import br.com.manageFinanceWallet.Model.DTO.OperationDTO;
import br.com.manageFinanceWallet.Service.Impl.OperationServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/operation")
public class OperationResource {
    @Autowired
    private OperationServiceimpl operationService;

    @GetMapping
    public ResponseEntity<List<OperationDTO>> getAllOperation(){
        return ResponseEntity.ok(operationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationDTO> getOneOperation(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(operationService.getOneOperation(id));
    }

    @PostMapping
    public ResponseEntity<OperationDTO> createNewOperation(@RequestBody @Valid OperationDTO operation){

        OperationEntity operationEntity = operationService.saveNewOperation(operation);

        URI uri = URI.create("/operation/"+operationEntity.getCodigo());

        return ResponseEntity.created(uri).build();
    }

}
