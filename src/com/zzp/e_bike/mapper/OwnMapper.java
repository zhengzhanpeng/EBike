package com.zzp.e_bike.mapper;

import com.zzp.e_bike.DTO.OwnUnique;
import com.zzp.e_bike.pojo.Own;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ho
 * @create 2017-07-18 17:52
 */
public interface OwnMapper {
    int addOwn(Own own);
    int delete(int id);
    int setOwn(Own own);

    /**
     *
     * @param str
     * @param order order == 1 欠款升序排序；order == 0 欠款降序排序
     *              order == 2 日期降序排序；order == 3 日期升序排序
     * @return
     */
    List<OwnUnique> getOwns(@Param("str") String str, @Param("order") Integer order, @Param("styleGet") int styleGet);

    int repayMoney(@Param("id") int id, @Param("money") int money);

    Own getOwn(int ownId);
}
