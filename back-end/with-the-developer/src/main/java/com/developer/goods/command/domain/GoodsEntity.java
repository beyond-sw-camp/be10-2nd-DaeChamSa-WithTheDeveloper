package com.developer.goods.command.domain;

import com.developer.common.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDateTime;

@Entity
@Table(name = "goods")
@Getter
@SQLDelete(sql="UPDATE goods SET del_status = true WHERE goods_code=?")
public class GoodsEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long goodsCode;
    private String goodsName;
    private String goodsContent;
    private int goodsStock;
    private String goodsStatus;
    private int goodsPrice;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private boolean delStatus=false;


    public GoodsEntity() {
    }

    // 굿즈 등록
    public GoodsEntity(String goodsName, String goodsContent, int goodsStock, String goodsStatus, int goodsPrice) {
        this.goodsName = goodsName;
        this.goodsContent = goodsContent;
        this.goodsStock = goodsStock;
        this.goodsStatus = goodsStatus;
        this.goodsPrice = goodsPrice;
    }

    // 굿즈 업데이트
    public void updateGoods(String goodsName, String goodsContent, int goodsStock, String goodsStatus, int goodsPrice) {
        this.goodsName = goodsName;
        this.goodsContent = goodsContent;
        this.goodsStock = goodsStock;
        this.goodsStatus = goodsStatus;
        this.goodsPrice = goodsPrice;
    }


}