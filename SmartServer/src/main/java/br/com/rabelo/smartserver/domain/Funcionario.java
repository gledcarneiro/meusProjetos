package br.com.rabelo.smartserver.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "funcionario", catalog = "retaguarda")
public class Funcionario extends GenericDomain {
	@Column(length = 5)
	private String fun_matr;

	@Column(length = 20)
	private String fun_nome;

	@Column(length = 33)
	private String fun_nmfunc;

	@Column(length = 2)
	private String fun_loja;

	@Column(length = 1)
	private Character fun_tipo;

	@Column(length = 1)
	private Character fun_ativ;

	@Column(precision = 5, scale = 2)
	private BigDecimal fun_perc;

	@Column(length = 20)
	private String fun_cargo;

	@Column(precision = 10, scale = 2)
	private BigDecimal fun_salar;

	@Column(length = 1)
	private Character fun_sind;

	@Column(length = 1)
	private Character fun_tran;

	@Column(length = 1)
	private Character fun_vale;

	@Column(length = 1)
	private Character fun_depe;

	@Column(length = 1)
	private Character fun_cart;

	@Column(precision = 10, scale = 2)
	private BigDecimal fun_liquid;

	@Column(precision = 10, scale = 2)
	private BigDecimal fun_liquip;

	@Column(length = 1)
	private Short fun_depr;

	@Column(length = 2)
	private String fun_hora;

	@Column(precision = 10, scale = 2)
	private BigDecimal fun_comiss;

	@Column(length = 2)
	private Short fun_reserv;

	@Temporal(TemporalType.DATE)
	@Column(length = 10)
	private Date fun_dtadmi;

	@Column(precision = 10, scale = 2)
	private BigDecimal fun_fora;

	@Temporal(TemporalType.DATE)
	@Column(length = 10)
	private Date fun_dtnasc;

	@Column(length = 2)
	private String fun_extra;

	@Column(length = 1)
	private Character fun_pont;

	@Column(length = 4)
	private String fun_senha;

	@Column(length = 1)
	private Short fun_acesso;

	@Column(length = 1)
	private Character fun_impcom;

	@Column(length = 20)
	private String fun_premia;

	@Column(length = 100)
	private String fun_progra;

	@Column(length = 1)
	private Character fun_ptoulj;

	@Column(length = 2)
	private String fun_codset;

	@Temporal(TemporalType.DATE)
	@Column(length = 10)
	private Date fun_dtdesl;

	@Column(length = 14)
	private String fun_fone1;

	@Column(length = 14)
	private String fun_fone2;

	@Column(length = 11)
	private String fun_cpf;

	@Temporal(TemporalType.DATE)
	@Column(length = 10)
	private Date fun_dtsenh;

	@Column(length = 5)
	private Short fun_diasts;

	@Column(length = 5)
	private Short fun_nivsen;

	@Column(length = 100)
	private String fun_ultsen;

	@Column(length = 1)
	private Short fun_qterrs;

	@Temporal(TemporalType.DATE)
	@Column(length = 10)
	private Date fun_ulogdt;

	@Column(length = 5)
	private String fun_uloghr;

	@Column(length = 20)
	private String fun_ulogte;

	@Column(length = 10)
	private String fun_passwd;

	@Column(length = 6)
	private String fun_cdsfpg;

	public String getFun_matr() {
		return fun_matr;
	}

	public void setFun_matr(String fun_matr) {
		this.fun_matr = fun_matr;
	}

	public String getFun_nome() {
		return fun_nome;
	}

	public void setFun_nome(String fun_nome) {
		this.fun_nome = fun_nome;
	}

	public String getFun_nmfunc() {
		return fun_nmfunc;
	}

	public void setFun_nmfunc(String fun_nmfunc) {
		this.fun_nmfunc = fun_nmfunc;
	}

	public String getFun_loja() {
		return fun_loja;
	}

	public void setFun_loja(String fun_loja) {
		this.fun_loja = fun_loja;
	}

	public Character getFun_tipo() {
		return fun_tipo;
	}

	public void setFun_tipo(Character fun_tipo) {
		this.fun_tipo = fun_tipo;
	}

	public Character getFun_ativ() {
		return fun_ativ;
	}

	public void setFun_ativ(Character fun_ativ) {
		this.fun_ativ = fun_ativ;
	}

	public BigDecimal getFun_perc() {
		return fun_perc;
	}

	public void setFun_perc(BigDecimal fun_perc) {
		this.fun_perc = fun_perc;
	}

	public String getFun_cargo() {
		return fun_cargo;
	}

	public void setFun_cargo(String fun_cargo) {
		this.fun_cargo = fun_cargo;
	}

	public BigDecimal getFun_salar() {
		return fun_salar;
	}

	public void setFun_salar(BigDecimal fun_salar) {
		this.fun_salar = fun_salar;
	}

	public Character getFun_sind() {
		return fun_sind;
	}

	public void setFun_sind(Character fun_sind) {
		this.fun_sind = fun_sind;
	}

	public Character getFun_tran() {
		return fun_tran;
	}

	public void setFun_tran(Character fun_tran) {
		this.fun_tran = fun_tran;
	}

	public Character getFun_vale() {
		return fun_vale;
	}

	public void setFun_vale(Character fun_vale) {
		this.fun_vale = fun_vale;
	}

	public Character getFun_depe() {
		return fun_depe;
	}

	public void setFun_depe(Character fun_depe) {
		this.fun_depe = fun_depe;
	}

	public Character getFun_cart() {
		return fun_cart;
	}

	public void setFun_cart(Character fun_cart) {
		this.fun_cart = fun_cart;
	}

	public BigDecimal getFun_liquid() {
		return fun_liquid;
	}

	public void setFun_liquid(BigDecimal fun_liquid) {
		this.fun_liquid = fun_liquid;
	}

	public BigDecimal getFun_liquip() {
		return fun_liquip;
	}

	public void setFun_liquip(BigDecimal fun_liquip) {
		this.fun_liquip = fun_liquip;
	}

	public Short getFun_depr() {
		return fun_depr;
	}

	public void setFun_depr(Short fun_depr) {
		this.fun_depr = fun_depr;
	}

	public String getFun_hora() {
		return fun_hora;
	}

	public void setFun_hora(String fun_hora) {
		this.fun_hora = fun_hora;
	}

	public BigDecimal getFun_comiss() {
		return fun_comiss;
	}

	public void setFun_comiss(BigDecimal fun_comiss) {
		this.fun_comiss = fun_comiss;
	}

	public Short getFun_reserv() {
		return fun_reserv;
	}

	public void setFun_reserv(Short fun_reserv) {
		this.fun_reserv = fun_reserv;
	}

	public Date getFun_dtadmi() {
		return fun_dtadmi;
	}

	public void setFun_dtadmi(Date fun_dtadmi) {
		this.fun_dtadmi = fun_dtadmi;
	}

	public BigDecimal getFun_fora() {
		return fun_fora;
	}

	public void setFun_fora(BigDecimal fun_fora) {
		this.fun_fora = fun_fora;
	}

	public Date getFun_dtnasc() {
		return fun_dtnasc;
	}

	public void setFun_dtnasc(Date fun_dtnasc) {
		this.fun_dtnasc = fun_dtnasc;
	}

	public String getFun_extra() {
		return fun_extra;
	}

	public void setFun_extra(String fun_extra) {
		this.fun_extra = fun_extra;
	}

	public Character getFun_pont() {
		return fun_pont;
	}

	public void setFun_pont(Character fun_pont) {
		this.fun_pont = fun_pont;
	}

	public String getFun_senha() {
		return fun_senha;
	}

	public void setFun_senha(String fun_senha) {
		this.fun_senha = fun_senha;
	}

	public Short getFun_acesso() {
		return fun_acesso;
	}

	public void setFun_acesso(Short fun_acesso) {
		this.fun_acesso = fun_acesso;
	}

	public Character getFun_impcom() {
		return fun_impcom;
	}

	public void setFun_impcom(Character fun_impcom) {
		this.fun_impcom = fun_impcom;
	}

	public String getFun_premia() {
		return fun_premia;
	}

	public void setFun_premia(String fun_premia) {
		this.fun_premia = fun_premia;
	}

	public String getFun_progra() {
		return fun_progra;
	}

	public void setFun_progra(String fun_progra) {
		this.fun_progra = fun_progra;
	}

	public Character getFun_ptoulj() {
		return fun_ptoulj;
	}

	public void setFun_ptoulj(Character fun_ptoulj) {
		this.fun_ptoulj = fun_ptoulj;
	}

	public String getFun_codset() {
		return fun_codset;
	}

	public void setFun_codset(String fun_codset) {
		this.fun_codset = fun_codset;
	}

	public Date getFun_dtdesl() {
		return fun_dtdesl;
	}

	public void setFun_dtdesl(Date fun_dtdesl) {
		this.fun_dtdesl = fun_dtdesl;
	}

	public String getFun_fone1() {
		return fun_fone1;
	}

	public void setFun_fone1(String fun_fone1) {
		this.fun_fone1 = fun_fone1;
	}

	public String getFun_fone2() {
		return fun_fone2;
	}

	public void setFun_fone2(String fun_fone2) {
		this.fun_fone2 = fun_fone2;
	}

	public String getFun_cpf() {
		return fun_cpf;
	}

	public void setFun_cpf(String fun_cpf) {
		this.fun_cpf = fun_cpf;
	}

	public Date getFun_dtsenh() {
		return fun_dtsenh;
	}

	public void setFun_dtsenh(Date fun_dtsenh) {
		this.fun_dtsenh = fun_dtsenh;
	}

	public Short getFun_diasts() {
		return fun_diasts;
	}

	public void setFun_diasts(Short fun_diasts) {
		this.fun_diasts = fun_diasts;
	}

	public Short getFun_nivsen() {
		return fun_nivsen;
	}

	public void setFun_nivsen(Short fun_nivsen) {
		this.fun_nivsen = fun_nivsen;
	}

	public String getFun_ultsen() {
		return fun_ultsen;
	}

	public void setFun_ultsen(String fun_ultsen) {
		this.fun_ultsen = fun_ultsen;
	}

	public Short getFun_qterrs() {
		return fun_qterrs;
	}

	public void setFun_qterrs(Short fun_qterrs) {
		this.fun_qterrs = fun_qterrs;
	}

	public Date getFun_ulogdt() {
		return fun_ulogdt;
	}

	public void setFun_ulogdt(Date fun_ulogdt) {
		this.fun_ulogdt = fun_ulogdt;
	}

	public String getFun_uloghr() {
		return fun_uloghr;
	}

	public void setFun_uloghr(String fun_uloghr) {
		this.fun_uloghr = fun_uloghr;
	}

	public String getFun_ulogte() {
		return fun_ulogte;
	}

	public void setFun_ulogte(String fun_ulogte) {
		this.fun_ulogte = fun_ulogte;
	}

	public String getFun_passwd() {
		return fun_passwd;
	}

	public void setFun_passwd(String fun_passwd) {
		this.fun_passwd = fun_passwd;
	}

	public String getFun_cdsfpg() {
		return fun_cdsfpg;
	}

	public void setFun_cdsfpg(String fun_cdsfpg) {
		this.fun_cdsfpg = fun_cdsfpg;
	}
}
