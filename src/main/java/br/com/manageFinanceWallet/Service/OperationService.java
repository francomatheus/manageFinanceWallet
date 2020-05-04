package br.com.manageFinanceWallet.Service;

import br.com.manageFinanceWallet.Entity.OperationEntity;
import br.com.manageFinanceWallet.Model.DTO.OperationDTO;

import java.util.List;
import java.util.Optional;

public interface OperationService {

    List<OperationDTO> getAll();

    OperationEntity saveNewOperation(OperationDTO operation);

    OperationDTO getOneOperation(Long id);

}
