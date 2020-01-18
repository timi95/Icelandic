package Iceland.Tech.Test.iceland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Iceland.Tech.Test.iceland.models.StoreItem;

/**
 * StoreItemRepository
 */
public interface StoreItemRepository extends JpaRepository<StoreItem, Long> {

    
}