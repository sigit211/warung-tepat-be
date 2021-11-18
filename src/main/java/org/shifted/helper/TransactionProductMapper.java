package org.shifted.helper;

import org.shifted.entity.cart.CartDAO;
import org.shifted.entity.transaction.TransactionDAO;
import org.shifted.entity.transaction.TransactionDTO;
import org.shifted.repository.CartContentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TransactionProductMapper {

    @Autowired
    CartContentRepository cartContentRepository;

    public List<TransactionDTO> productMapper(List<TransactionDAO> transactions){
        ArrayList<TransactionDTO> transactionList = new ArrayList<>();
        for (TransactionDAO transaction : transactions) {
            CartDAO cartDAO = transaction.getCart();
            TransactionDTO userTransaction = new TransactionDTO(
                    transaction.getTransaction_id(),
                    transaction.getUser_id(),
                    transaction.getTransaction_date(),
                    transaction.getRef_code(),
                    transaction.getTransaction_amount(),
                    transaction.getTransaction_status(),
                    cartContentRepository.findProductInCartByCartId(cartDAO.getCart_id())
            );
            transactionList.add(userTransaction);
        }
        return transactionList;
    }

}
