package deco;

public class Audi_A4 extends AudiDecorator{

	public Audi_A4(ICar audi, String modelName, int modelPrice) {
		super(audi, modelName, 30_000_000);
	}
	
	

}
