package Iceland.Tech.Test.iceland.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import Iceland.Tech.Test.iceland.dto.StoreItemDTO;
import Iceland.Tech.Test.iceland.models.StoreItem;
import Iceland.Tech.Test.iceland.repositories.StoreItemRepository;
import Iceland.Tech.Test.iceland.responses.ApiResponse;
import Iceland.Tech.Test.iceland.responses.DefaultResponses;

/**
 * StoreService
 */
@Service
@Repository
public class StoreService {

    @Autowired
    private StoreItemRepository storeItemRepository;

    public ApiResponse getItems(int page, int size) {
        Page<StoreItem> items = storeItemRepository.findAll(pageRequestForIdDesc(page,size));
        return DefaultResponses.response200("Successfully fetched all Items ", items.getContent(), items.getTotalElements());
    }

    public ApiResponse createStoreItem(StoreItemDTO itemDTO) {
        StoreItem item = new StoreItem();
        item.setQualityValue(itemDTO.getQualityValue());
        item.setSellInValue(itemDTO.getSellInValue());
        return new ApiResponse(true, "Successfully Created Article", storeItemRepository.save(item));
    }

        //private methods used by this class
        private PageRequest pageRequestForIdDesc(int page, int size){
            return PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        } 
    
        private PageRequest pageRequestOrderByName(int page, int size){
            return PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));
        }



    
}