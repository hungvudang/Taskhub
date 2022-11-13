package taskhub.persistence.entity.sa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import taskhub.persistence.entity.Abstract_entity;
import taskhub.persistence.entity._Pk;

@SuppressWarnings("serial")
@Entity
public class Sa_order_ost_det extends Abstract_entity {
	
	@EmbeddedId
	private Pk pk;
	@Column(updatable = false, insertable = false)
	private String sales_order_no;
	
	@Column(updatable = false, insertable = false)
	private int pk_no_det;
	
	protected Sa_order_ost_det() {
	}
	
	public Sa_order_ost_det(final String sales_order_no, final int pk_no_det) {
		this.pk = new Pk(sales_order_no, pk_no_det);
		this.sales_order_no = sales_order_no;
		this.pk_no_det = pk_no_det;
	}
	
	public String getSales_order_no() {
		return this.pk.getSales_order_no();
	}
	
	public int getPk_no_det() {
		return this.pk.getPk_no_det();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "sales_order_no", referencedColumnName = "sales_order_no", updatable = false, insertable = false)
	})
	private Sa_order_ost_hdr sa_order_ost_hdr;
	
	public Sa_order_ost_hdr getSa_order_ost_hdr() {
		return this.sa_order_ost_hdr;
	}

	public void setSa_order_ost_hdr(Sa_order_ost_hdr sa_order_ost_hdr) {
		this.sa_order_ost_hdr = sa_order_ost_hdr;
	}

	@Override
	public _Pk getPk() {
		return this.pk;
	}
	
	@Embeddable
	public static class Pk extends _Pk {
		
		@Column(insertable = false, updatable = false, length = 50)
		@Size(max = 50)
		private String sales_order_no;
		
		@Column(insertable = false, updatable = false)
		private int pk_no_det;
		
		public Pk() {
		}
		
		public Pk(@Size(max = 50) String sales_order_no, int pk_no_det) {
			this.sales_order_no = sales_order_no;
			this.pk_no_det = pk_no_det;
		}

		public String getSales_order_no() {
			return this.sales_order_no;
		}

		public int getPk_no_det() {
			return this.pk_no_det;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.pk_no_det;
			result = prime * result + ((this.sales_order_no == null) ? 0 : this.sales_order_no.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pk other = (Pk) obj;
			if (this.pk_no_det != other.pk_no_det)
				return false;
			if (this.sales_order_no == null) {
				if (other.sales_order_no != null)
					return false;
			} else if (!this.sales_order_no.equals(other.sales_order_no))
				return false;
			return true;
		}
		
		
	}
	
}