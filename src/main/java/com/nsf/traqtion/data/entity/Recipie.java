package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the recipie database table.
 * 
 */
@Entity
@Table(name="recipie")
@NamedQuery(name="Recipie.findAll", query="SELECT r FROM Recipie r")
public class Recipie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="recipie_id")
	private String recipieId;

	@Column(name="additive_function")
	private String additiveFunction;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	private String declare1;

	@Column(name="declared_quid_percent")
	private String declaredQuidPercent;

	@Column(name="default_uom")
	private String defaultUom;

	@Column(name="final_calc_quid_percent")
	private String finalCalcQuidPercent;

	@Column(name="final_product_percent")
	private String finalProductPercent;

	@Column(name="final_product_qty")
	private Long finalProductQty;

	@Column(name="final_product_uom")
	private String finalProductUom;

	@Column(name="group_name")
	private String groupName;

	@Column(name="include_quid")
	private String includeQuid;

	@Column(name="ingredient_info")
	private String ingredientInfo;

	@Column(name="intial_product_percent")
	private Long intialProductPercent;

	@Column(name="intial_product_qty")
	private Long intialProductQty;

	@Column(name="intial_product_uom")
	private String intialProductUom;

	private String item;

	@Column(name="processing_loss")
	private String processingLoss;

	@Column(name="processing_loss_percent")
	private Long processingLossPercent;

	private String rank;

	@Column(name="row_no")
	private String rowNo;

	private String type;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	public Recipie() {
	}

	public String getRecipieId() {
		return this.recipieId;
	}

	public void setRecipieId(String recipieId) {
		this.recipieId = recipieId;
	}

	public String getAdditiveFunction() {
		return this.additiveFunction;
	}

	public void setAdditiveFunction(String additiveFunction) {
		this.additiveFunction = additiveFunction;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getDeclare1() {
		return this.declare1;
	}

	public void setDeclare1(String declare1) {
		this.declare1 = declare1;
	}

	public String getDeclaredQuidPercent() {
		return this.declaredQuidPercent;
	}

	public void setDeclaredQuidPercent(String declaredQuidPercent) {
		this.declaredQuidPercent = declaredQuidPercent;
	}

	public String getDefaultUom() {
		return this.defaultUom;
	}

	public void setDefaultUom(String defaultUom) {
		this.defaultUom = defaultUom;
	}

	public String getFinalCalcQuidPercent() {
		return this.finalCalcQuidPercent;
	}

	public void setFinalCalcQuidPercent(String finalCalcQuidPercent) {
		this.finalCalcQuidPercent = finalCalcQuidPercent;
	}

	public String getFinalProductPercent() {
		return this.finalProductPercent;
	}

	public void setFinalProductPercent(String finalProductPercent) {
		this.finalProductPercent = finalProductPercent;
	}

	public Long getFinalProductQty() {
		return this.finalProductQty;
	}

	public void setFinalProductQty(Long finalProductQty) {
		this.finalProductQty = finalProductQty;
	}

	public String getFinalProductUom() {
		return this.finalProductUom;
	}

	public void setFinalProductUom(String finalProductUom) {
		this.finalProductUom = finalProductUom;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getIncludeQuid() {
		return this.includeQuid;
	}

	public void setIncludeQuid(String includeQuid) {
		this.includeQuid = includeQuid;
	}

	public String getIngredientInfo() {
		return this.ingredientInfo;
	}

	public void setIngredientInfo(String ingredientInfo) {
		this.ingredientInfo = ingredientInfo;
	}

	public Long getIntialProductPercent() {
		return this.intialProductPercent;
	}

	public void setIntialProductPercent(Long intialProductPercent) {
		this.intialProductPercent = intialProductPercent;
	}

	public Long getIntialProductQty() {
		return this.intialProductQty;
	}

	public void setIntialProductQty(Long intialProductQty) {
		this.intialProductQty = intialProductQty;
	}

	public String getIntialProductUom() {
		return this.intialProductUom;
	}

	public void setIntialProductUom(String intialProductUom) {
		this.intialProductUom = intialProductUom;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getProcessingLoss() {
		return this.processingLoss;
	}

	public void setProcessingLoss(String processingLoss) {
		this.processingLoss = processingLoss;
	}

	public Long getProcessingLossPercent() {
		return this.processingLossPercent;
	}

	public void setProcessingLossPercent(Long processingLossPercent) {
		this.processingLossPercent = processingLossPercent;
	}

	public String getRank() {
		return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getRowNo() {
		return this.rowNo;
	}

	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

}