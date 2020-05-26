package br.com.manageFinanceWallet.Service.Impl;

import br.com.manageFinanceWallet.Entity.OperationEntity;
import br.com.manageFinanceWallet.Model.DTO.OperationDTO;
import br.com.manageFinanceWallet.Model.form.OperationForm;
import br.com.manageFinanceWallet.Repository.OperationRepository;
import br.com.manageFinanceWallet.Service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperationServiceimpl implements OperationService {
    @Autowired
    private OperationRepository operationRepository;

    @Override
    public List<OperationDTO> getAll() {
        return converterListEntityForDTO(operationRepository.findAll());
    }

    public OperationEntity saveNewOperation(OperationDTO operation){
        OperationEntity OperationCreated = operationRepository.save(converterDTOForEntity(operation));
        return OperationCreated;
    }

    @Override
    public OperationDTO getOneOperation(Long id) {
        OperationDTO operation = converterEntityForDTO(operationRepository.findById(id));
        return operation;
    }

    public OperationDTO createNewOperation(OperationForm operationForm){

        


        return null;
    }


    private OperationEntity converterDTOForEntity(OperationDTO operation) {
        OperationEntity newOperation = new OperationEntity();
        newOperation.setStock(operation.getStock());
        newOperation.setQuantity(operation.getQuantity());
        newOperation.setPrice(operation.getPrice());
        newOperation.setOperationType(operation.getOperationType());
        newOperation.setDateOpen(operation.getDateOpen());
        newOperation.setDateClose(operation.getDateClose());
        newOperation.setBroker(operation.getBroker());
        return newOperation;
    }

    private List<OperationDTO> converterListEntityForDTO(List<OperationEntity> all) {
        List<OperationDTO> operations = new ArrayList<>();
        all.forEach( operation -> {
            OperationDTO newOperation = new OperationDTO();
            newOperation.setBroker(operation.getBroker());
            newOperation.setCodigo(operation.getCodigo());
            newOperation.setDateClose(operation.getDateClose());
            newOperation.setDateOpen(operation.getDateOpen());
            newOperation.setOperationType(operation.getOperationType());
            newOperation.setPrice(operation.getPrice());
            newOperation.setQuantity(operation.getQuantity());
            newOperation.setStock(operation.getStock());

            operations.add(newOperation);
        } );
        return operations;
    }
    private OperationDTO converterEntityForDTO(Optional<OperationEntity> all) {
        if (all.isPresent()) {
            OperationDTO operations = new OperationDTO();

            operations.setBroker(all.get().getBroker());
            operations.setCodigo(all.get().getCodigo());
            operations.setDateClose(all.get().getDateClose());
            operations.setDateOpen(all.get().getDateOpen());
            operations.setOperationType(all.get().getOperationType());
            operations.setPrice(all.get().getPrice());
            operations.setQuantity(all.get().getQuantity());
            operations.setStock(all.get().getStock());

            return operations;
        }
        throw new IllegalArgumentException("ID doesn't exist");
    }

}
