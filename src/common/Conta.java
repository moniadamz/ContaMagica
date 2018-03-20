package common;

	import java.math.BigDecimal;

	public class Conta {

		private String nome;
		private Categorias categoria;
		private BigDecimal saldo;

		public Conta(String nome) {
			this.nome = nome;
			saldo = BigDecimal.ZERO;
			categoria = Categorias.SILVER;
		}

		public String getNomeCliente() {
			return this.nome;
		}

		public BigDecimal getSaldo() {
			return this.saldo;
		}

		public Categorias getStatus() {
			return this.categoria;
		}

		public String deposito(double valor) {
			BigDecimal a = new BigDecimal(valor);
			if ((a.compareTo(BigDecimal.ZERO) == 1)) {
				if (a.compareTo(new BigDecimal(50000.00)) == -1) {
					this.saldo = saldo.add(a);
				} else if (a.compareTo(new BigDecimal(50000.00)) == 0
						|| a.compareTo(new BigDecimal(50000.00)) == 1 && a.compareTo(new BigDecimal(200000.00)) == -1) {
					this.saldo = saldo.add(a.multiply(new BigDecimal(0.01)).add(a));
					this.categoria = Categorias.GOLD;
				} else if (a.compareTo(new BigDecimal(200000.00)) == 0 || a.compareTo(new BigDecimal(200000.00)) == 1) {
					this.saldo = saldo.add(a.multiply(new BigDecimal(0.025)).add(a));
					this.categoria = Categorias.PLATINUM;
				}
				return ("Depósito Efetuado.");
			} else {
				return ("Valor inválido.");
			}
		}

		public void atualizaStatus() {
			if ( this.saldo.compareTo(new BigDecimal(25000.00)) == 0 || this.saldo.compareTo(new BigDecimal(25000.00)) == 1 && this.saldo.compareTo(new BigDecimal(100000.00)) == -1) {
				this.categoria = Categorias.GOLD;
			} else if (this.saldo.compareTo(new BigDecimal(25000.00)) == -1) {
				categoria = Categorias.SILVER;
			}
		}

		public String retirada(double valor) {
			BigDecimal a = new BigDecimal(valor);
			if (a.compareTo(saldo) == 0 || a.compareTo(saldo) == -1 ) {
				saldo = saldo.subtract(a);
				atualizaStatus();
				return "Retirada Efetuada.";
			} else {
				return ("Valor inválido para retirada.");
			}
		}
	}
