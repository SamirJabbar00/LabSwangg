package it.unibo.sweng.simplegwt.shared;

public class CardMagic extends Card{

	private static final long serialVersionUID = 1L;
	private String artist;
	private String rarity;
	private String types;
	private String text;
	private String hasFoil;
	private String isAlternative;
	private String isFullArt;
	private String isPromo;
	private String isReprint;
	
	public CardMagic() {}
	
	public CardMagic(String name,int Id,  String artist, String rarity,String types,String text, String hasfoil, String isAlternative, String isReprint, String isPromo, String isFullArt)
	{
		super(name,Id);
		this.artist=artist;
		this.types=types;
		this.text=text;
		this.rarity=rarity;
		this.hasFoil=hasfoil;
		this.isAlternative=isAlternative;
		this.isPromo=isPromo;
		this.isReprint=isReprint;
		this.isFullArt=isFullArt;
	}
	
	public String getArtist()
	{
		return this.artist;
	}
	
	public String getRarity()
	{
		return this.rarity;
	}
	
	public String getType()
	{
		return this.types;
	}
	
	public String getText()
	{
		return this.text;
	}
	
	public String getFoil()
	{
		return this.hasFoil;
	}
	
	public String getFullArt()
	{
		return this.isFullArt;
	}
	
	public String getPromo()
	{
		return this.isPromo;
	}
	
	public String getReprint()
	{
		return this.isReprint;
	}
	
	public String getAlternative()
	{
		return this.isAlternative;
	}
	
	@Override
	public String returnCard()
	{
		return this.getId()+"\n"+this.getArtist()+"\n"+this.getName()+"\n"+this.getType()+"\n"+this.getRarity()+"\n"+this.getFoil()+"\n"+this.getAlternative()+"\n"+this.getFullArt()+"\n"+this.getPromo()+"\n"+this.getReprint()+"\n"+this.getText();
	}
	
}
