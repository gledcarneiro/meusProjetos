package br.com.rabelo.smartserver.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EcfVendaDetalhe generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ecf_venda_detalhe", catalog = "retaguarda")
public class EcfVendaDetalhe extends GenericDomain {

	private EcfVendaCabecalho ecfVendaCabecalho;
	private int idEcfProduto;
	private String nomeCaixa;
	private Integer idGeradoCaixa;
	private Integer idEmpresa;
	private int cfop;
	private String gtin;
	private Integer ccf;
	private Integer coo;
	private String serieEcf;
	private Integer item;
	private BigDecimal quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal valorTotal;
	private BigDecimal totalItem;
	private BigDecimal baseIcms;
	private BigDecimal taxaIcms;
	private BigDecimal icms;
	private BigDecimal taxaDesconto;
	private BigDecimal desconto;
	private BigDecimal taxaIssqn;
	private BigDecimal issqn;
	private BigDecimal taxaPis;
	private BigDecimal pis;
	private BigDecimal taxaCofins;
	private BigDecimal cofins;
	private BigDecimal taxaAcrescimo;
	private BigDecimal acrescimo;
	private BigDecimal acrescimoRateio;
	private BigDecimal descontoRateio;
	private String totalizadorParcial;
	private String cst;
	private Character cancelado;
	private Character movimentaEstoque;
	private String ecfIcmsSt;
	private String hashTripa;
	private Integer hashIncremento;
	private String observacao;
	private BigDecimal icmsIsento;
	private BigDecimal icmsSubstituicao;
	private BigDecimal icmsNaoTributado;
	private Date dataSincronizacao;
	private String horaSincronizacao;

	public EcfVendaDetalhe() {
	}

	public EcfVendaDetalhe(EcfVendaCabecalho ecfVendaCabecalho, int idEcfProduto, int cfop) {
		this.ecfVendaCabecalho = ecfVendaCabecalho;
		this.idEcfProduto = idEcfProduto;
		this.cfop = cfop;
	}

	public EcfVendaDetalhe(EcfVendaCabecalho ecfVendaCabecalho, int idEcfProduto, String nomeCaixa,
			Integer idGeradoCaixa, Integer idEmpresa, int cfop, String gtin, Integer ccf, Integer coo, String serieEcf,
			Integer item, BigDecimal quantidade, BigDecimal valorUnitario, BigDecimal valorTotal, BigDecimal totalItem,
			BigDecimal baseIcms, BigDecimal taxaIcms, BigDecimal icms, BigDecimal taxaDesconto, BigDecimal desconto,
			BigDecimal taxaIssqn, BigDecimal issqn, BigDecimal taxaPis, BigDecimal pis, BigDecimal taxaCofins,
			BigDecimal cofins, BigDecimal taxaAcrescimo, BigDecimal acrescimo, BigDecimal acrescimoRateio,
			BigDecimal descontoRateio, String totalizadorParcial, String cst, Character cancelado,
			Character movimentaEstoque, String ecfIcmsSt, String hashTripa, Integer hashIncremento, String observacao,
			BigDecimal icmsIsento, BigDecimal icmsSubstituicao, BigDecimal icmsNaoTributado, Date dataSincronizacao,
			String horaSincronizacao) {
		this.ecfVendaCabecalho = ecfVendaCabecalho;
		this.idEcfProduto = idEcfProduto;
		this.nomeCaixa = nomeCaixa;
		this.idGeradoCaixa = idGeradoCaixa;
		this.idEmpresa = idEmpresa;
		this.cfop = cfop;
		this.gtin = gtin;
		this.ccf = ccf;
		this.coo = coo;
		this.serieEcf = serieEcf;
		this.item = item;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
		this.totalItem = totalItem;
		this.baseIcms = baseIcms;
		this.taxaIcms = taxaIcms;
		this.icms = icms;
		this.taxaDesconto = taxaDesconto;
		this.desconto = desconto;
		this.taxaIssqn = taxaIssqn;
		this.issqn = issqn;
		this.taxaPis = taxaPis;
		this.pis = pis;
		this.taxaCofins = taxaCofins;
		this.cofins = cofins;
		this.taxaAcrescimo = taxaAcrescimo;
		this.acrescimo = acrescimo;
		this.acrescimoRateio = acrescimoRateio;
		this.descontoRateio = descontoRateio;
		this.totalizadorParcial = totalizadorParcial;
		this.cst = cst;
		this.cancelado = cancelado;
		this.movimentaEstoque = movimentaEstoque;
		this.ecfIcmsSt = ecfIcmsSt;
		this.hashTripa = hashTripa;
		this.hashIncremento = hashIncremento;
		this.observacao = observacao;
		this.icmsIsento = icmsIsento;
		this.icmsSubstituicao = icmsSubstituicao;
		this.icmsNaoTributado = icmsNaoTributado;
		this.dataSincronizacao = dataSincronizacao;
		this.horaSincronizacao = horaSincronizacao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ECF_VENDA_CABECALHO", nullable = false)
	public EcfVendaCabecalho getEcfVendaCabecalho() {
		return this.ecfVendaCabecalho;
	}

	public void setEcfVendaCabecalho(EcfVendaCabecalho ecfVendaCabecalho) {
		this.ecfVendaCabecalho = ecfVendaCabecalho;
	}

	@Column(name = "ID_ECF_PRODUTO", nullable = false)
	public int getIdEcfProduto() {
		return this.idEcfProduto;
	}

	public void setIdEcfProduto(int idEcfProduto) {
		this.idEcfProduto = idEcfProduto;
	}

	@Column(name = "NOME_CAIXA", length = 30)
	public String getNomeCaixa() {
		return this.nomeCaixa;
	}

	public void setNomeCaixa(String nomeCaixa) {
		this.nomeCaixa = nomeCaixa;
	}

	@Column(name = "ID_GERADO_CAIXA")
	public Integer getIdGeradoCaixa() {
		return this.idGeradoCaixa;
	}

	public void setIdGeradoCaixa(Integer idGeradoCaixa) {
		this.idGeradoCaixa = idGeradoCaixa;
	}

	@Column(name = "ID_EMPRESA")
	public Integer getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	@Column(name = "CFOP", nullable = false)
	public int getCfop() {
		return this.cfop;
	}

	public void setCfop(int cfop) {
		this.cfop = cfop;
	}

	@Column(name = "GTIN", length = 14)
	public String getGtin() {
		return this.gtin;
	}

	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

	@Column(name = "CCF")
	public Integer getCcf() {
		return this.ccf;
	}

	public void setCcf(Integer ccf) {
		this.ccf = ccf;
	}

	@Column(name = "COO")
	public Integer getCoo() {
		return this.coo;
	}

	public void setCoo(Integer coo) {
		this.coo = coo;
	}

	@Column(name = "SERIE_ECF", length = 20)
	public String getSerieEcf() {
		return this.serieEcf;
	}

	public void setSerieEcf(String serieEcf) {
		this.serieEcf = serieEcf;
	}

	@Column(name = "ITEM")
	public Integer getItem() {
		return this.item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	@Column(name = "QUANTIDADE", precision = 18, scale = 6)
	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	@Column(name = "VALOR_UNITARIO", precision = 18, scale = 6)
	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@Column(name = "VALOR_TOTAL", precision = 18, scale = 6)
	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Column(name = "TOTAL_ITEM", precision = 18, scale = 6)
	public BigDecimal getTotalItem() {
		return this.totalItem;
	}

	public void setTotalItem(BigDecimal totalItem) {
		this.totalItem = totalItem;
	}

	@Column(name = "BASE_ICMS", precision = 18, scale = 6)
	public BigDecimal getBaseIcms() {
		return this.baseIcms;
	}

	public void setBaseIcms(BigDecimal baseIcms) {
		this.baseIcms = baseIcms;
	}

	@Column(name = "TAXA_ICMS", precision = 18, scale = 6)
	public BigDecimal getTaxaIcms() {
		return this.taxaIcms;
	}

	public void setTaxaIcms(BigDecimal taxaIcms) {
		this.taxaIcms = taxaIcms;
	}

	@Column(name = "ICMS", precision = 18, scale = 6)
	public BigDecimal getIcms() {
		return this.icms;
	}

	public void setIcms(BigDecimal icms) {
		this.icms = icms;
	}

	@Column(name = "TAXA_DESCONTO", precision = 18, scale = 6)
	public BigDecimal getTaxaDesconto() {
		return this.taxaDesconto;
	}

	public void setTaxaDesconto(BigDecimal taxaDesconto) {
		this.taxaDesconto = taxaDesconto;
	}

	@Column(name = "DESCONTO", precision = 18, scale = 6)
	public BigDecimal getDesconto() {
		return this.desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	@Column(name = "TAXA_ISSQN", precision = 18, scale = 6)
	public BigDecimal getTaxaIssqn() {
		return this.taxaIssqn;
	}

	public void setTaxaIssqn(BigDecimal taxaIssqn) {
		this.taxaIssqn = taxaIssqn;
	}

	@Column(name = "ISSQN", precision = 18, scale = 6)
	public BigDecimal getIssqn() {
		return this.issqn;
	}

	public void setIssqn(BigDecimal issqn) {
		this.issqn = issqn;
	}

	@Column(name = "TAXA_PIS", precision = 18, scale = 6)
	public BigDecimal getTaxaPis() {
		return this.taxaPis;
	}

	public void setTaxaPis(BigDecimal taxaPis) {
		this.taxaPis = taxaPis;
	}

	@Column(name = "PIS", precision = 18, scale = 6)
	public BigDecimal getPis() {
		return this.pis;
	}

	public void setPis(BigDecimal pis) {
		this.pis = pis;
	}

	@Column(name = "TAXA_COFINS", precision = 18, scale = 6)
	public BigDecimal getTaxaCofins() {
		return this.taxaCofins;
	}

	public void setTaxaCofins(BigDecimal taxaCofins) {
		this.taxaCofins = taxaCofins;
	}

	@Column(name = "COFINS", precision = 18, scale = 6)
	public BigDecimal getCofins() {
		return this.cofins;
	}

	public void setCofins(BigDecimal cofins) {
		this.cofins = cofins;
	}

	@Column(name = "TAXA_ACRESCIMO", precision = 18, scale = 6)
	public BigDecimal getTaxaAcrescimo() {
		return this.taxaAcrescimo;
	}

	public void setTaxaAcrescimo(BigDecimal taxaAcrescimo) {
		this.taxaAcrescimo = taxaAcrescimo;
	}

	@Column(name = "ACRESCIMO", precision = 18, scale = 6)
	public BigDecimal getAcrescimo() {
		return this.acrescimo;
	}

	public void setAcrescimo(BigDecimal acrescimo) {
		this.acrescimo = acrescimo;
	}

	@Column(name = "ACRESCIMO_RATEIO", precision = 18, scale = 6)
	public BigDecimal getAcrescimoRateio() {
		return this.acrescimoRateio;
	}

	public void setAcrescimoRateio(BigDecimal acrescimoRateio) {
		this.acrescimoRateio = acrescimoRateio;
	}

	@Column(name = "DESCONTO_RATEIO", precision = 18, scale = 6)
	public BigDecimal getDescontoRateio() {
		return this.descontoRateio;
	}

	public void setDescontoRateio(BigDecimal descontoRateio) {
		this.descontoRateio = descontoRateio;
	}

	@Column(name = "TOTALIZADOR_PARCIAL", length = 10)
	public String getTotalizadorParcial() {
		return this.totalizadorParcial;
	}

	public void setTotalizadorParcial(String totalizadorParcial) {
		this.totalizadorParcial = totalizadorParcial;
	}

	@Column(name = "CST", length = 3)
	public String getCst() {
		return this.cst;
	}

	public void setCst(String cst) {
		this.cst = cst;
	}

	@Column(name = "CANCELADO", length = 1)
	public Character getCancelado() {
		return this.cancelado;
	}

	public void setCancelado(Character cancelado) {
		this.cancelado = cancelado;
	}

	@Column(name = "MOVIMENTA_ESTOQUE", length = 1)
	public Character getMovimentaEstoque() {
		return this.movimentaEstoque;
	}

	public void setMovimentaEstoque(Character movimentaEstoque) {
		this.movimentaEstoque = movimentaEstoque;
	}

	@Column(name = "ECF_ICMS_ST", length = 4)
	public String getEcfIcmsSt() {
		return this.ecfIcmsSt;
	}

	public void setEcfIcmsSt(String ecfIcmsSt) {
		this.ecfIcmsSt = ecfIcmsSt;
	}

	@Column(name = "HASH_TRIPA", length = 32)
	public String getHashTripa() {
		return this.hashTripa;
	}

	public void setHashTripa(String hashTripa) {
		this.hashTripa = hashTripa;
	}

	@Column(name = "HASH_INCREMENTO")
	public Integer getHashIncremento() {
		return this.hashIncremento;
	}

	public void setHashIncremento(Integer hashIncremento) {
		this.hashIncremento = hashIncremento;
	}

	@Column(name = "OBSERVACAO", length = 100)
	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Column(name = "ICMS_ISENTO", precision = 18, scale = 6)
	public BigDecimal getIcmsIsento() {
		return this.icmsIsento;
	}

	public void setIcmsIsento(BigDecimal icmsIsento) {
		this.icmsIsento = icmsIsento;
	}

	@Column(name = "ICMS_SUBSTITUICAO", precision = 18, scale = 6)
	public BigDecimal getIcmsSubstituicao() {
		return this.icmsSubstituicao;
	}

	public void setIcmsSubstituicao(BigDecimal icmsSubstituicao) {
		this.icmsSubstituicao = icmsSubstituicao;
	}

	@Column(name = "ICMS_NAO_TRIBUTADO", precision = 18, scale = 6)
	public BigDecimal getIcmsNaoTributado() {
		return this.icmsNaoTributado;
	}

	public void setIcmsNaoTributado(BigDecimal icmsNaoTributado) {
		this.icmsNaoTributado = icmsNaoTributado;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_SINCRONIZACAO", length = 10)
	public Date getDataSincronizacao() {
		return this.dataSincronizacao;
	}

	public void setDataSincronizacao(Date dataSincronizacao) {
		this.dataSincronizacao = dataSincronizacao;
	}

	@Column(name = "HORA_SINCRONIZACAO", length = 8)
	public String getHoraSincronizacao() {
		return this.horaSincronizacao;
	}

	public void setHoraSincronizacao(String horaSincronizacao) {
		this.horaSincronizacao = horaSincronizacao;
	}

}
