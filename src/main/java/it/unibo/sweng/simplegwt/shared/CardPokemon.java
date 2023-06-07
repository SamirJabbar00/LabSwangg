package it.unibo.sweng.simplegwt.shared;

public class CardPokemon extends Card {

	private static final long serialVersionUID = 1L;
	private String illustrator;
	private String image;
	private String rarity;
	private String type;
	private String description;
	//TODO: Sotto-Oggetto Variant
	
	public CardPokemon() {}
	
	public CardPokemon(String name,int Id,  String illustrator, String image,String rarity,String type,String description)
	{
		super(name,Id);
		this.illustrator=illustrator;
		this.image=image;
		this.type=type;
		this.description=description;
		this.rarity=rarity;
		
	}
	
	public String getIllustrator()
	{
		return this.illustrator;
	}
	
	public String getImage()
	{
		return this.image;
	}
	
	public String getRarity()
	{
		return this.rarity;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	@Override
	public String returnCard()
	{
		return this.getId()+this.getIllustrator()+this.getName();
	}
	
}
