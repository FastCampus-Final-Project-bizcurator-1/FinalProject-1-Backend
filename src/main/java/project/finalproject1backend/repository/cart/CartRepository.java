package project.finalproject1backend.repository.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.finalproject1backend.domain.Cart;
import project.finalproject1backend.domain.User;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByCartUser(User user);
    Optional<Cart> findByCartUser_Id(Long Id);
}