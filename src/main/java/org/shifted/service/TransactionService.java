package org.shifted.service;

import org.shifted.entity.cart.CartDAO;
import org.shifted.entity.transaction.TransactionDAO;
import org.shifted.entity.transaction.TransactionDTO;
import org.shifted.repository.CartContentRepository;
import org.shifted.repository.CartRepository;
import org.shifted.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CartContentRepository cartContentRepository;

    @Autowired
    CartRepository cartRepository;

    public TransactionDAO saveTransaction(TransactionDAO transactionDAO) {
        CartDAO cart = cartRepository.findByCartId(transactionDAO.getCart().getCart_id());
        cart.setCart_status("Checked out");
        cartRepository.save(cart);
        return transactionRepository.save(transactionDAO);
    }

    public List<TransactionDTO> findTransaction(String user_id) {
        List<TransactionDAO> transactions = transactionRepository.findByUserId(user_id);
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
