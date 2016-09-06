package com.nsf.traqtion.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the supplier_specification database table.
 * 
 */
@Entity
@Table(name="supplier_specification")
@NamedQuery(name="SupplierSpecification.findAll", query="SELECT s FROM SupplierSpecification s")
public class SupplierSpecification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="supplier_spec_id")
	private String supplierSpecId;

	@Column(name="commercial_status")
	private String commercialStatus;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(name="primary_spec_seq_no")
	private String primarySpecSeqNo;

	private String reason;

	@Column(name="specification_status")
	private String specificationStatus;

	@Column(name="supplier_spec_name")
	private String supplierSpecName;

	@Column(name="supplier_spec_seq_no")
	private String supplierSpecSeqNo;

	@Column(name="supplier_version_no")
	private String supplierVersionNo;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="updated_date")
	private Timestamp updatedDate;

	@Column(name="version_end_date")
	private Timestamp versionEndDate;

	@Column(name="version_start_date")
	private Timestamp versionStartDate;

	//bi-directional many-to-one association to BbqOthCookingSafety
	@OneToMany(mappedBy="supplierSpecification")
	private List<BbqOthCookingSafety> bbqOthCookingSafeties;

	//bi-directional many-to-one association to CookOrHeatOnHob
	@OneToMany(mappedBy="supplierSpecification")
	private List<CookOrHeatOnHob> cookOrHeatOnHobs;

	//bi-directional many-to-one association to DeclaredQuantity
	@OneToMany(mappedBy="supplierSpecification")
	private List<DeclaredQuantity> declaredQuantities;

	//bi-directional many-to-one association to DietaryImprovement
	@OneToMany(mappedBy="supplierSpecification")
	private List<DietaryImprovement> dietaryImprovements;

	//bi-directional many-to-one association to Frying
	@OneToMany(mappedBy="supplierSpecification")
	private List<Frying> fryings;

	//bi-directional many-to-one association to IngredientsNCompound
	@OneToMany(mappedBy="supplierSpecification")
	private List<IngredientsNCompound> ingredientsNCompounds;

	//bi-directional many-to-one association to LabelDeclaration
	@OneToMany(mappedBy="supplierSpecification")
	private List<LabelDeclaration> labelDeclarations;

	//bi-directional many-to-one association to LegalLabelling
	@OneToMany(mappedBy="supplierSpecification")
	private List<LegalLabelling> legalLabellings;

	//bi-directional many-to-one association to LegalStatement
	@OneToMany(mappedBy="supplierSpecification")
	private List<LegalStatement> legalStatements;

	//bi-directional many-to-one association to Microwave
	@OneToMany(mappedBy="supplierSpecification")
	private List<Microwave> microwaves;

	//bi-directional many-to-one association to Nutrition
	@OneToMany(mappedBy="supplierSpecification")
	private List<Nutrition> nutritions;

	//bi-directional many-to-one association to OriginOfMeat
	@OneToMany(mappedBy="supplierSpecification")
	private List<OriginOfMeat> originOfMeats;

	//bi-directional many-to-one association to Oven
	@OneToMany(mappedBy="supplierSpecification")
	private List<Oven> ovens;

	//bi-directional many-to-one association to PackCodingNShelfLife
	@OneToMany(mappedBy="supplierSpecification")
	private List<PackCodingNShelfLife> packCodingNShelfLifes;

	//bi-directional many-to-one association to ProductCodesNRef
	@OneToMany(mappedBy="supplierSpecification")
	private List<ProductCodesNRef> productCodesNRefs;

	//bi-directional many-to-one association to ProductDcAssociation
	@OneToMany(mappedBy="supplierSpecification")
	private List<ProductDcAssociation> productDcAssociations;

	//bi-directional many-to-one association to ProductServiceProdAssociation
	@OneToMany(mappedBy="supplierSpecification")
	private List<ProductServiceProdAssociation> productServiceProdAssociations;

	//bi-directional many-to-one association to ProductSourcing
	@OneToMany(mappedBy="supplierSpecification")
	private List<ProductSourcing> productSourcings;

	//bi-directional many-to-one association to ProductSupplierAssociation
	@OneToMany(mappedBy="supplierSpecification")
	private List<ProductSupplierAssociation> productSupplierAssociations;

	//bi-directional many-to-one association to SteamGrillDeepfry
	@OneToMany(mappedBy="supplierSpecification")
	private List<SteamGrillDeepfry> steamGrillDeepfries;

	//bi-directional many-to-one association to StoreFreezDefro
	@OneToMany(mappedBy="supplierSpecification")
	private List<StoreFreezDefro> storeFreezDefros;

	//bi-directional many-to-one association to SupplierDistribution
	@OneToMany(mappedBy="supplierSpecification")
	private List<SupplierDistribution> supplierDistributions;

	//bi-directional many-to-one association to PrimarySpecification
	@ManyToOne
	@JoinColumn(name="primary_spec_id")
	private PrimarySpecification primarySpecification;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;

	//bi-directional many-to-one association to WfObject
	@OneToMany(mappedBy="supplierSpecification")
	private List<WfObject> wfObjects;

	public SupplierSpecification() {
	}

	public String getSupplierSpecId() {
		return this.supplierSpecId;
	}

	public void setSupplierSpecId(String supplierSpecId) {
		this.supplierSpecId = supplierSpecId;
	}

	public String getCommercialStatus() {
		return this.commercialStatus;
	}

	public void setCommercialStatus(String commercialStatus) {
		this.commercialStatus = commercialStatus;
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

	public String getPrimarySpecSeqNo() {
		return this.primarySpecSeqNo;
	}

	public void setPrimarySpecSeqNo(String primarySpecSeqNo) {
		this.primarySpecSeqNo = primarySpecSeqNo;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSpecificationStatus() {
		return this.specificationStatus;
	}

	public void setSpecificationStatus(String specificationStatus) {
		this.specificationStatus = specificationStatus;
	}

	public String getSupplierSpecName() {
		return this.supplierSpecName;
	}

	public void setSupplierSpecName(String supplierSpecName) {
		this.supplierSpecName = supplierSpecName;
	}

	public String getSupplierSpecSeqNo() {
		return this.supplierSpecSeqNo;
	}

	public void setSupplierSpecSeqNo(String supplierSpecSeqNo) {
		this.supplierSpecSeqNo = supplierSpecSeqNo;
	}

	public String getSupplierVersionNo() {
		return this.supplierVersionNo;
	}

	public void setSupplierVersionNo(String supplierVersionNo) {
		this.supplierVersionNo = supplierVersionNo;
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

	public Timestamp getVersionEndDate() {
		return this.versionEndDate;
	}

	public void setVersionEndDate(Timestamp versionEndDate) {
		this.versionEndDate = versionEndDate;
	}

	public Timestamp getVersionStartDate() {
		return this.versionStartDate;
	}

	public void setVersionStartDate(Timestamp versionStartDate) {
		this.versionStartDate = versionStartDate;
	}

	public List<BbqOthCookingSafety> getBbqOthCookingSafeties() {
		return this.bbqOthCookingSafeties;
	}

	public void setBbqOthCookingSafeties(List<BbqOthCookingSafety> bbqOthCookingSafeties) {
		this.bbqOthCookingSafeties = bbqOthCookingSafeties;
	}

	public BbqOthCookingSafety addBbqOthCookingSafety(BbqOthCookingSafety bbqOthCookingSafety) {
		getBbqOthCookingSafeties().add(bbqOthCookingSafety);
		bbqOthCookingSafety.setSupplierSpecification(this);

		return bbqOthCookingSafety;
	}

	public BbqOthCookingSafety removeBbqOthCookingSafety(BbqOthCookingSafety bbqOthCookingSafety) {
		getBbqOthCookingSafeties().remove(bbqOthCookingSafety);
		bbqOthCookingSafety.setSupplierSpecification(null);

		return bbqOthCookingSafety;
	}

	public List<CookOrHeatOnHob> getCookOrHeatOnHobs() {
		return this.cookOrHeatOnHobs;
	}

	public void setCookOrHeatOnHobs(List<CookOrHeatOnHob> cookOrHeatOnHobs) {
		this.cookOrHeatOnHobs = cookOrHeatOnHobs;
	}

	public CookOrHeatOnHob addCookOrHeatOnHob(CookOrHeatOnHob cookOrHeatOnHob) {
		getCookOrHeatOnHobs().add(cookOrHeatOnHob);
		cookOrHeatOnHob.setSupplierSpecification(this);

		return cookOrHeatOnHob;
	}

	public CookOrHeatOnHob removeCookOrHeatOnHob(CookOrHeatOnHob cookOrHeatOnHob) {
		getCookOrHeatOnHobs().remove(cookOrHeatOnHob);
		cookOrHeatOnHob.setSupplierSpecification(null);

		return cookOrHeatOnHob;
	}

	public List<DeclaredQuantity> getDeclaredQuantities() {
		return this.declaredQuantities;
	}

	public void setDeclaredQuantities(List<DeclaredQuantity> declaredQuantities) {
		this.declaredQuantities = declaredQuantities;
	}

	public DeclaredQuantity addDeclaredQuantity(DeclaredQuantity declaredQuantity) {
		getDeclaredQuantities().add(declaredQuantity);
		declaredQuantity.setSupplierSpecification(this);

		return declaredQuantity;
	}

	public DeclaredQuantity removeDeclaredQuantity(DeclaredQuantity declaredQuantity) {
		getDeclaredQuantities().remove(declaredQuantity);
		declaredQuantity.setSupplierSpecification(null);

		return declaredQuantity;
	}

	public List<DietaryImprovement> getDietaryImprovements() {
		return this.dietaryImprovements;
	}

	public void setDietaryImprovements(List<DietaryImprovement> dietaryImprovements) {
		this.dietaryImprovements = dietaryImprovements;
	}

	public DietaryImprovement addDietaryImprovement(DietaryImprovement dietaryImprovement) {
		getDietaryImprovements().add(dietaryImprovement);
		dietaryImprovement.setSupplierSpecification(this);

		return dietaryImprovement;
	}

	public DietaryImprovement removeDietaryImprovement(DietaryImprovement dietaryImprovement) {
		getDietaryImprovements().remove(dietaryImprovement);
		dietaryImprovement.setSupplierSpecification(null);

		return dietaryImprovement;
	}

	public List<Frying> getFryings() {
		return this.fryings;
	}

	public void setFryings(List<Frying> fryings) {
		this.fryings = fryings;
	}

	public Frying addFrying(Frying frying) {
		getFryings().add(frying);
		frying.setSupplierSpecification(this);

		return frying;
	}

	public Frying removeFrying(Frying frying) {
		getFryings().remove(frying);
		frying.setSupplierSpecification(null);

		return frying;
	}

	public List<IngredientsNCompound> getIngredientsNCompounds() {
		return this.ingredientsNCompounds;
	}

	public void setIngredientsNCompounds(List<IngredientsNCompound> ingredientsNCompounds) {
		this.ingredientsNCompounds = ingredientsNCompounds;
	}

	public IngredientsNCompound addIngredientsNCompound(IngredientsNCompound ingredientsNCompound) {
		getIngredientsNCompounds().add(ingredientsNCompound);
		ingredientsNCompound.setSupplierSpecification(this);

		return ingredientsNCompound;
	}

	public IngredientsNCompound removeIngredientsNCompound(IngredientsNCompound ingredientsNCompound) {
		getIngredientsNCompounds().remove(ingredientsNCompound);
		ingredientsNCompound.setSupplierSpecification(null);

		return ingredientsNCompound;
	}

	public List<LabelDeclaration> getLabelDeclarations() {
		return this.labelDeclarations;
	}

	public void setLabelDeclarations(List<LabelDeclaration> labelDeclarations) {
		this.labelDeclarations = labelDeclarations;
	}

	public LabelDeclaration addLabelDeclaration(LabelDeclaration labelDeclaration) {
		getLabelDeclarations().add(labelDeclaration);
		labelDeclaration.setSupplierSpecification(this);

		return labelDeclaration;
	}

	public LabelDeclaration removeLabelDeclaration(LabelDeclaration labelDeclaration) {
		getLabelDeclarations().remove(labelDeclaration);
		labelDeclaration.setSupplierSpecification(null);

		return labelDeclaration;
	}

	public List<LegalLabelling> getLegalLabellings() {
		return this.legalLabellings;
	}

	public void setLegalLabellings(List<LegalLabelling> legalLabellings) {
		this.legalLabellings = legalLabellings;
	}

	public LegalLabelling addLegalLabelling(LegalLabelling legalLabelling) {
		getLegalLabellings().add(legalLabelling);
		legalLabelling.setSupplierSpecification(this);

		return legalLabelling;
	}

	public LegalLabelling removeLegalLabelling(LegalLabelling legalLabelling) {
		getLegalLabellings().remove(legalLabelling);
		legalLabelling.setSupplierSpecification(null);

		return legalLabelling;
	}

	public List<LegalStatement> getLegalStatements() {
		return this.legalStatements;
	}

	public void setLegalStatements(List<LegalStatement> legalStatements) {
		this.legalStatements = legalStatements;
	}

	public LegalStatement addLegalStatement(LegalStatement legalStatement) {
		getLegalStatements().add(legalStatement);
		legalStatement.setSupplierSpecification(this);

		return legalStatement;
	}

	public LegalStatement removeLegalStatement(LegalStatement legalStatement) {
		getLegalStatements().remove(legalStatement);
		legalStatement.setSupplierSpecification(null);

		return legalStatement;
	}

	public List<Microwave> getMicrowaves() {
		return this.microwaves;
	}

	public void setMicrowaves(List<Microwave> microwaves) {
		this.microwaves = microwaves;
	}

	public Microwave addMicrowave(Microwave microwave) {
		getMicrowaves().add(microwave);
		microwave.setSupplierSpecification(this);

		return microwave;
	}

	public Microwave removeMicrowave(Microwave microwave) {
		getMicrowaves().remove(microwave);
		microwave.setSupplierSpecification(null);

		return microwave;
	}

	public List<Nutrition> getNutritions() {
		return this.nutritions;
	}

	public void setNutritions(List<Nutrition> nutritions) {
		this.nutritions = nutritions;
	}

	public Nutrition addNutrition(Nutrition nutrition) {
		getNutritions().add(nutrition);
		nutrition.setSupplierSpecification(this);

		return nutrition;
	}

	public Nutrition removeNutrition(Nutrition nutrition) {
		getNutritions().remove(nutrition);
		nutrition.setSupplierSpecification(null);

		return nutrition;
	}

	public List<OriginOfMeat> getOriginOfMeats() {
		return this.originOfMeats;
	}

	public void setOriginOfMeats(List<OriginOfMeat> originOfMeats) {
		this.originOfMeats = originOfMeats;
	}

	public OriginOfMeat addOriginOfMeat(OriginOfMeat originOfMeat) {
		getOriginOfMeats().add(originOfMeat);
		originOfMeat.setSupplierSpecification(this);

		return originOfMeat;
	}

	public OriginOfMeat removeOriginOfMeat(OriginOfMeat originOfMeat) {
		getOriginOfMeats().remove(originOfMeat);
		originOfMeat.setSupplierSpecification(null);

		return originOfMeat;
	}

	public List<Oven> getOvens() {
		return this.ovens;
	}

	public void setOvens(List<Oven> ovens) {
		this.ovens = ovens;
	}

	public Oven addOven(Oven oven) {
		getOvens().add(oven);
		oven.setSupplierSpecification(this);

		return oven;
	}

	public Oven removeOven(Oven oven) {
		getOvens().remove(oven);
		oven.setSupplierSpecification(null);

		return oven;
	}

	public List<PackCodingNShelfLife> getPackCodingNShelfLifes() {
		return this.packCodingNShelfLifes;
	}

	public void setPackCodingNShelfLifes(List<PackCodingNShelfLife> packCodingNShelfLifes) {
		this.packCodingNShelfLifes = packCodingNShelfLifes;
	}

	public PackCodingNShelfLife addPackCodingNShelfLife(PackCodingNShelfLife packCodingNShelfLife) {
		getPackCodingNShelfLifes().add(packCodingNShelfLife);
		packCodingNShelfLife.setSupplierSpecification(this);

		return packCodingNShelfLife;
	}

	public PackCodingNShelfLife removePackCodingNShelfLife(PackCodingNShelfLife packCodingNShelfLife) {
		getPackCodingNShelfLifes().remove(packCodingNShelfLife);
		packCodingNShelfLife.setSupplierSpecification(null);

		return packCodingNShelfLife;
	}

	public List<ProductCodesNRef> getProductCodesNRefs() {
		return this.productCodesNRefs;
	}

	public void setProductCodesNRefs(List<ProductCodesNRef> productCodesNRefs) {
		this.productCodesNRefs = productCodesNRefs;
	}

	public ProductCodesNRef addProductCodesNRef(ProductCodesNRef productCodesNRef) {
		getProductCodesNRefs().add(productCodesNRef);
		productCodesNRef.setSupplierSpecification(this);

		return productCodesNRef;
	}

	public ProductCodesNRef removeProductCodesNRef(ProductCodesNRef productCodesNRef) {
		getProductCodesNRefs().remove(productCodesNRef);
		productCodesNRef.setSupplierSpecification(null);

		return productCodesNRef;
	}

	public List<ProductDcAssociation> getProductDcAssociations() {
		return this.productDcAssociations;
	}

	public void setProductDcAssociations(List<ProductDcAssociation> productDcAssociations) {
		this.productDcAssociations = productDcAssociations;
	}

	public ProductDcAssociation addProductDcAssociation(ProductDcAssociation productDcAssociation) {
		getProductDcAssociations().add(productDcAssociation);
		productDcAssociation.setSupplierSpecification(this);

		return productDcAssociation;
	}

	public ProductDcAssociation removeProductDcAssociation(ProductDcAssociation productDcAssociation) {
		getProductDcAssociations().remove(productDcAssociation);
		productDcAssociation.setSupplierSpecification(null);

		return productDcAssociation;
	}

	public List<ProductServiceProdAssociation> getProductServiceProdAssociations() {
		return this.productServiceProdAssociations;
	}

	public void setProductServiceProdAssociations(List<ProductServiceProdAssociation> productServiceProdAssociations) {
		this.productServiceProdAssociations = productServiceProdAssociations;
	}

	public ProductServiceProdAssociation addProductServiceProdAssociation(ProductServiceProdAssociation productServiceProdAssociation) {
		getProductServiceProdAssociations().add(productServiceProdAssociation);
		productServiceProdAssociation.setSupplierSpecification(this);

		return productServiceProdAssociation;
	}

	public ProductServiceProdAssociation removeProductServiceProdAssociation(ProductServiceProdAssociation productServiceProdAssociation) {
		getProductServiceProdAssociations().remove(productServiceProdAssociation);
		productServiceProdAssociation.setSupplierSpecification(null);

		return productServiceProdAssociation;
	}

	public List<ProductSourcing> getProductSourcings() {
		return this.productSourcings;
	}

	public void setProductSourcings(List<ProductSourcing> productSourcings) {
		this.productSourcings = productSourcings;
	}

	public ProductSourcing addProductSourcing(ProductSourcing productSourcing) {
		getProductSourcings().add(productSourcing);
		productSourcing.setSupplierSpecification(this);

		return productSourcing;
	}

	public ProductSourcing removeProductSourcing(ProductSourcing productSourcing) {
		getProductSourcings().remove(productSourcing);
		productSourcing.setSupplierSpecification(null);

		return productSourcing;
	}

	public List<ProductSupplierAssociation> getProductSupplierAssociations() {
		return this.productSupplierAssociations;
	}

	public void setProductSupplierAssociations(List<ProductSupplierAssociation> productSupplierAssociations) {
		this.productSupplierAssociations = productSupplierAssociations;
	}

	public ProductSupplierAssociation addProductSupplierAssociation(ProductSupplierAssociation productSupplierAssociation) {
		getProductSupplierAssociations().add(productSupplierAssociation);
		productSupplierAssociation.setSupplierSpecification(this);

		return productSupplierAssociation;
	}

	public ProductSupplierAssociation removeProductSupplierAssociation(ProductSupplierAssociation productSupplierAssociation) {
		getProductSupplierAssociations().remove(productSupplierAssociation);
		productSupplierAssociation.setSupplierSpecification(null);

		return productSupplierAssociation;
	}

	public List<SteamGrillDeepfry> getSteamGrillDeepfries() {
		return this.steamGrillDeepfries;
	}

	public void setSteamGrillDeepfries(List<SteamGrillDeepfry> steamGrillDeepfries) {
		this.steamGrillDeepfries = steamGrillDeepfries;
	}

	public SteamGrillDeepfry addSteamGrillDeepfry(SteamGrillDeepfry steamGrillDeepfry) {
		getSteamGrillDeepfries().add(steamGrillDeepfry);
		steamGrillDeepfry.setSupplierSpecification(this);

		return steamGrillDeepfry;
	}

	public SteamGrillDeepfry removeSteamGrillDeepfry(SteamGrillDeepfry steamGrillDeepfry) {
		getSteamGrillDeepfries().remove(steamGrillDeepfry);
		steamGrillDeepfry.setSupplierSpecification(null);

		return steamGrillDeepfry;
	}

	public List<StoreFreezDefro> getStoreFreezDefros() {
		return this.storeFreezDefros;
	}

	public void setStoreFreezDefros(List<StoreFreezDefro> storeFreezDefros) {
		this.storeFreezDefros = storeFreezDefros;
	}

	public StoreFreezDefro addStoreFreezDefro(StoreFreezDefro storeFreezDefro) {
		getStoreFreezDefros().add(storeFreezDefro);
		storeFreezDefro.setSupplierSpecification(this);

		return storeFreezDefro;
	}

	public StoreFreezDefro removeStoreFreezDefro(StoreFreezDefro storeFreezDefro) {
		getStoreFreezDefros().remove(storeFreezDefro);
		storeFreezDefro.setSupplierSpecification(null);

		return storeFreezDefro;
	}

	public List<SupplierDistribution> getSupplierDistributions() {
		return this.supplierDistributions;
	}

	public void setSupplierDistributions(List<SupplierDistribution> supplierDistributions) {
		this.supplierDistributions = supplierDistributions;
	}

	public SupplierDistribution addSupplierDistribution(SupplierDistribution supplierDistribution) {
		getSupplierDistributions().add(supplierDistribution);
		supplierDistribution.setSupplierSpecification(this);

		return supplierDistribution;
	}

	public SupplierDistribution removeSupplierDistribution(SupplierDistribution supplierDistribution) {
		getSupplierDistributions().remove(supplierDistribution);
		supplierDistribution.setSupplierSpecification(null);

		return supplierDistribution;
	}

	public PrimarySpecification getPrimarySpecification() {
		return this.primarySpecification;
	}

	public void setPrimarySpecification(PrimarySpecification primarySpecification) {
		this.primarySpecification = primarySpecification;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<WfObject> getWfObjects() {
		return this.wfObjects;
	}

	public void setWfObjects(List<WfObject> wfObjects) {
		this.wfObjects = wfObjects;
	}

	public WfObject addWfObject(WfObject wfObject) {
		getWfObjects().add(wfObject);
		wfObject.setSupplierSpecification(this);

		return wfObject;
	}

	public WfObject removeWfObject(WfObject wfObject) {
		getWfObjects().remove(wfObject);
		wfObject.setSupplierSpecification(null);

		return wfObject;
	}

}