package jp.co.internous.utopia.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.utopia.model.domain.MstProduct;

@Mapper
public interface MstProductMapper {

	@Select("SELECT * FROM mst_product")
	List<MstProduct> findAll();
	
	@Select("SELECT * FROM mst_product WHERE id = #{id}")
	MstProduct findById(int id);
	
	List<MstProduct> findByArrayProductName(
			@Param("arrayProductName") String[] arrayProductName);
	
	@Select("SELECT * FROM mst_product WHERE category_id = #{categoryId}")
	List<MstProduct> findByCategoryId(int categoryId);
	
	List<MstProduct> findByCategoryIdAndProductName(
			@Param("categoryId") int categoryId,
			@Param("arrayProductName") String[] arrayProductName);
}
