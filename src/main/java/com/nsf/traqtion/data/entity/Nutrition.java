package com.nsf.traqtion.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the nutrition database table.
 * 
 */
@Entity
@Table(name="nutrition")
@NamedQuery(name="Nutrition.findAll", query="SELECT n FROM Nutrition n")
public class Nutrition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nutrition_id")
	private String nutritionId;

	@Column(name="Actual")
	private String actual;

	@Column(name="All_cells")
	private String all_cells;

	@Column(name="All_nutrient_Column_1")
	private String all_nutrient_Column_1;

	@Column(name="All_nutrient_Column_2")
	private String all_nutrient_Column_2;

	@Column(name="All_nutrients_excluding")
	private String all_nutrients_excluding;

	@Column(name="All_output_panels")
	private String all_output_panels;

	@Column(name="As_consumed_1_2_3")
	private String as_consumed_1_2_3;

	@Column(name="Attribute1")
	private String attribute1;

	@Column(name="Attribute10")
	private String attribute10;

	@Column(name="Attribute2")
	private String attribute2;

	@Column(name="Attribute3")
	private String attribute3;

	@Column(name="Attribute4")
	private String attribute4;

	@Column(name="Attribute5")
	private String attribute5;

	@Column(name="Attribute6")
	private String attribute6;

	@Column(name="Attribute7")
	private String attribute7;

	@Column(name="Attribute8")
	private String attribute8;

	@Column(name="Attribute9")
	private String attribute9;

	@Column(name="Calculations_based_on")
	private String calculations_based_on;

	@Column(name="Column_1_heading")
	private String column_1_heading;

	@Column(name="Column_1_Per_100g_ml")
	private String column_1_Per_100g_ml;

	@Column(name="Column_2_heading")
	private String column_2_heading;

	@Column(name="Column_3_heading")
	private String column_3_heading;

	@Column(name="Column_4_heading")
	private String column_4_heading;

	@Column(name="Column_5_heading")
	private String column_5_heading;

	@Column(name="Column_6_heading")
	private String column_6_heading;

	@Column(name="Column_7_heading")
	private String column_7_heading;

	@Column(name="Column_8_heading")
	private String column_8_heading;

	@Column(name="consumed_1")
	private String consumed1;

	@Column(name="consumed_2")
	private String consumed2;

	@Column(name="consumed_3")
	private String consumed3;

	@Column(name="Container")
	private String container;

	@Column(name="Declared_Quantity")
	private String declared_Quantity;

	@Column(name="Declared_Quantity_UOM")
	private String declared_Quantity_UOM;

	@Column(name="Energy_kCals")
	private String energy_kCals;

	@Column(name="Energy_kJ")
	private String energy_kJ;

	private String FSA_Category;

	@Column(name="Include_RI_NRV_Values")
	private String include_RI_NRV_Values;

	@Column(name="No_Units")
	private String no_Units;

	@Column(name="Nutrient_column_heading")
	private String nutrient_column_heading;

	@Column(name="Nutrient_List_Type")
	private String nutrient_List_Type;

	@Column(name="Nutritional_Panel")
	private String nutritional_Panel;

	@Column(name="Other_declared")
	private String other_declared;

	@Column(name="Pack_Serv_heading")
	private String pack_Serv_heading;

	@Column(name="Per")
	private String per;

	@Column(name="Per_serv_calc")
	private String per_serv_calc;

	@Column(name="Per_Serving_ext")
	private String per_Serving_ext;

	private String RI_Calc;

	private String RI_NRV_per_100g;

	private String RI_NRV_per_serving;

	private String RI_Ref_Panel;

	@Column(name="Serving_Portions_per_pack")
	private String serving_Portions_per_pack;

	@Column(name="Serving_Quantity")
	private String serving_Quantity;

	@Column(name="Serving_Quantity_UOM")
	private String serving_Quantity_UOM;

	@Column(name="Vitamins_Minerals_Panel")
	private String vitamins_Minerals_Panel;

	//bi-directional many-to-one association to SupplierSpecification
	@ManyToOne
	@JoinColumn(name="supplier_spec_id")
	private SupplierSpecification supplierSpecification;

	public Nutrition() {
	}

	public String getNutritionId() {
		return this.nutritionId;
	}

	public void setNutritionId(String nutritionId) {
		this.nutritionId = nutritionId;
	}

	public String getActual() {
		return this.actual;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	public String getAll_cells() {
		return this.all_cells;
	}

	public void setAll_cells(String all_cells) {
		this.all_cells = all_cells;
	}

	public String getAll_nutrient_Column_1() {
		return this.all_nutrient_Column_1;
	}

	public void setAll_nutrient_Column_1(String all_nutrient_Column_1) {
		this.all_nutrient_Column_1 = all_nutrient_Column_1;
	}

	public String getAll_nutrient_Column_2() {
		return this.all_nutrient_Column_2;
	}

	public void setAll_nutrient_Column_2(String all_nutrient_Column_2) {
		this.all_nutrient_Column_2 = all_nutrient_Column_2;
	}

	public String getAll_nutrients_excluding() {
		return this.all_nutrients_excluding;
	}

	public void setAll_nutrients_excluding(String all_nutrients_excluding) {
		this.all_nutrients_excluding = all_nutrients_excluding;
	}

	public String getAll_output_panels() {
		return this.all_output_panels;
	}

	public void setAll_output_panels(String all_output_panels) {
		this.all_output_panels = all_output_panels;
	}

	public String getAs_consumed_1_2_3() {
		return this.as_consumed_1_2_3;
	}

	public void setAs_consumed_1_2_3(String as_consumed_1_2_3) {
		this.as_consumed_1_2_3 = as_consumed_1_2_3;
	}

	public String getAttribute1() {
		return this.attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute10() {
		return this.attribute10;
	}

	public void setAttribute10(String attribute10) {
		this.attribute10 = attribute10;
	}

	public String getAttribute2() {
		return this.attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute4() {
		return this.attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getAttribute5() {
		return this.attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public String getAttribute6() {
		return this.attribute6;
	}

	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}

	public String getAttribute7() {
		return this.attribute7;
	}

	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}

	public String getAttribute8() {
		return this.attribute8;
	}

	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}

	public String getAttribute9() {
		return this.attribute9;
	}

	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}

	public String getCalculations_based_on() {
		return this.calculations_based_on;
	}

	public void setCalculations_based_on(String calculations_based_on) {
		this.calculations_based_on = calculations_based_on;
	}

	public String getColumn_1_heading() {
		return this.column_1_heading;
	}

	public void setColumn_1_heading(String column_1_heading) {
		this.column_1_heading = column_1_heading;
	}

	public String getColumn_1_Per_100g_ml() {
		return this.column_1_Per_100g_ml;
	}

	public void setColumn_1_Per_100g_ml(String column_1_Per_100g_ml) {
		this.column_1_Per_100g_ml = column_1_Per_100g_ml;
	}

	public String getColumn_2_heading() {
		return this.column_2_heading;
	}

	public void setColumn_2_heading(String column_2_heading) {
		this.column_2_heading = column_2_heading;
	}

	public String getColumn_3_heading() {
		return this.column_3_heading;
	}

	public void setColumn_3_heading(String column_3_heading) {
		this.column_3_heading = column_3_heading;
	}

	public String getColumn_4_heading() {
		return this.column_4_heading;
	}

	public void setColumn_4_heading(String column_4_heading) {
		this.column_4_heading = column_4_heading;
	}

	public String getColumn_5_heading() {
		return this.column_5_heading;
	}

	public void setColumn_5_heading(String column_5_heading) {
		this.column_5_heading = column_5_heading;
	}

	public String getColumn_6_heading() {
		return this.column_6_heading;
	}

	public void setColumn_6_heading(String column_6_heading) {
		this.column_6_heading = column_6_heading;
	}

	public String getColumn_7_heading() {
		return this.column_7_heading;
	}

	public void setColumn_7_heading(String column_7_heading) {
		this.column_7_heading = column_7_heading;
	}

	public String getColumn_8_heading() {
		return this.column_8_heading;
	}

	public void setColumn_8_heading(String column_8_heading) {
		this.column_8_heading = column_8_heading;
	}

	public String getConsumed1() {
		return this.consumed1;
	}

	public void setConsumed1(String consumed1) {
		this.consumed1 = consumed1;
	}

	public String getConsumed2() {
		return this.consumed2;
	}

	public void setConsumed2(String consumed2) {
		this.consumed2 = consumed2;
	}

	public String getConsumed3() {
		return this.consumed3;
	}

	public void setConsumed3(String consumed3) {
		this.consumed3 = consumed3;
	}

	public String getContainer() {
		return this.container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getDeclared_Quantity() {
		return this.declared_Quantity;
	}

	public void setDeclared_Quantity(String declared_Quantity) {
		this.declared_Quantity = declared_Quantity;
	}

	public String getDeclared_Quantity_UOM() {
		return this.declared_Quantity_UOM;
	}

	public void setDeclared_Quantity_UOM(String declared_Quantity_UOM) {
		this.declared_Quantity_UOM = declared_Quantity_UOM;
	}

	public String getEnergy_kCals() {
		return this.energy_kCals;
	}

	public void setEnergy_kCals(String energy_kCals) {
		this.energy_kCals = energy_kCals;
	}

	public String getEnergy_kJ() {
		return this.energy_kJ;
	}

	public void setEnergy_kJ(String energy_kJ) {
		this.energy_kJ = energy_kJ;
	}

	public String getFSA_Category() {
		return this.FSA_Category;
	}

	public void setFSA_Category(String FSA_Category) {
		this.FSA_Category = FSA_Category;
	}

	public String getInclude_RI_NRV_Values() {
		return this.include_RI_NRV_Values;
	}

	public void setInclude_RI_NRV_Values(String include_RI_NRV_Values) {
		this.include_RI_NRV_Values = include_RI_NRV_Values;
	}

	public String getNo_Units() {
		return this.no_Units;
	}

	public void setNo_Units(String no_Units) {
		this.no_Units = no_Units;
	}

	public String getNutrient_column_heading() {
		return this.nutrient_column_heading;
	}

	public void setNutrient_column_heading(String nutrient_column_heading) {
		this.nutrient_column_heading = nutrient_column_heading;
	}

	public String getNutrient_List_Type() {
		return this.nutrient_List_Type;
	}

	public void setNutrient_List_Type(String nutrient_List_Type) {
		this.nutrient_List_Type = nutrient_List_Type;
	}

	public String getNutritional_Panel() {
		return this.nutritional_Panel;
	}

	public void setNutritional_Panel(String nutritional_Panel) {
		this.nutritional_Panel = nutritional_Panel;
	}

	public String getOther_declared() {
		return this.other_declared;
	}

	public void setOther_declared(String other_declared) {
		this.other_declared = other_declared;
	}

	public String getPack_Serv_heading() {
		return this.pack_Serv_heading;
	}

	public void setPack_Serv_heading(String pack_Serv_heading) {
		this.pack_Serv_heading = pack_Serv_heading;
	}

	public String getPer() {
		return this.per;
	}

	public void setPer(String per) {
		this.per = per;
	}

	public String getPer_serv_calc() {
		return this.per_serv_calc;
	}

	public void setPer_serv_calc(String per_serv_calc) {
		this.per_serv_calc = per_serv_calc;
	}

	public String getPer_Serving_ext() {
		return this.per_Serving_ext;
	}

	public void setPer_Serving_ext(String per_Serving_ext) {
		this.per_Serving_ext = per_Serving_ext;
	}

	public String getRI_Calc() {
		return this.RI_Calc;
	}

	public void setRI_Calc(String RI_Calc) {
		this.RI_Calc = RI_Calc;
	}

	public String getRI_NRV_per_100g() {
		return this.RI_NRV_per_100g;
	}

	public void setRI_NRV_per_100g(String RI_NRV_per_100g) {
		this.RI_NRV_per_100g = RI_NRV_per_100g;
	}

	public String getRI_NRV_per_serving() {
		return this.RI_NRV_per_serving;
	}

	public void setRI_NRV_per_serving(String RI_NRV_per_serving) {
		this.RI_NRV_per_serving = RI_NRV_per_serving;
	}

	public String getRI_Ref_Panel() {
		return this.RI_Ref_Panel;
	}

	public void setRI_Ref_Panel(String RI_Ref_Panel) {
		this.RI_Ref_Panel = RI_Ref_Panel;
	}

	public String getServing_Portions_per_pack() {
		return this.serving_Portions_per_pack;
	}

	public void setServing_Portions_per_pack(String serving_Portions_per_pack) {
		this.serving_Portions_per_pack = serving_Portions_per_pack;
	}

	public String getServing_Quantity() {
		return this.serving_Quantity;
	}

	public void setServing_Quantity(String serving_Quantity) {
		this.serving_Quantity = serving_Quantity;
	}

	public String getServing_Quantity_UOM() {
		return this.serving_Quantity_UOM;
	}

	public void setServing_Quantity_UOM(String serving_Quantity_UOM) {
		this.serving_Quantity_UOM = serving_Quantity_UOM;
	}

	public String getVitamins_Minerals_Panel() {
		return this.vitamins_Minerals_Panel;
	}

	public void setVitamins_Minerals_Panel(String vitamins_Minerals_Panel) {
		this.vitamins_Minerals_Panel = vitamins_Minerals_Panel;
	}

	public SupplierSpecification getSupplierSpecification() {
		return this.supplierSpecification;
	}

	public void setSupplierSpecification(SupplierSpecification supplierSpecification) {
		this.supplierSpecification = supplierSpecification;
	}

}