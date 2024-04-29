package characterManagement;

public abstract class Character {

	protected classType type;
	
	public classType getType() 
	{
		return type;
	}
	
	public void setType(classType type) 
	{
		this.type = type; 	
	}
}
