package  com.Clases.Model.Servicios;

import java.util.List;

import jakarta.persistence.*;

import  com.Clases.Model.ComunidadesYMiembros.Persona;
@Entity
//@Table(name = "Banio")
@DiscriminatorValue("BANIO")
public class Banio extends Servicio{
    /*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBanio;*/
	 @Enumerated(EnumType.ORDINAL)
    private TipoBanio tipoBanio;

    public Boolean PuedeUsar(Persona persona){
        //hacer
        return true;
    }

   
	public TipoBanio getTipoBanio() {
		return tipoBanio;
	}

	public void setTipoBanio(TipoBanio tipoBanio) {
		this.tipoBanio = tipoBanio;
	}

	private transient String TipoServicio= "Banio";
	public String getTipoServicio() {
		return TipoServicio;
	}
}

