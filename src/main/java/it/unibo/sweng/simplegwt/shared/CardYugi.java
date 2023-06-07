package it.unibo.sweng.simplegwt.shared;

public class CardYugi extends Card{

	private static final long serialVersionUID = 1L;
	private String race;
	private String type;
	private String desc;
	private String image_url;
	private String small_image_url;
	
	public CardYugi() {}
	
	public CardYugi(String name,int Id,  String race,String type,String desc, String image, String small_image)
	{
		super(name,Id);
		this.type=type;
		this.desc=desc;
		this.race=race;
		this.image_url=image;
		this.small_image_url=small_image;
	}
	
	public String getRace()
	{
		return this.race;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public String getDesc()
	{
		return this.desc;
	}
	
	public String getImage()
	{
		return this.image_url;
	}
	
	public String getSmallImage()
	{
		return this.small_image_url;
	}
	
	@Override
	public String returnCard()
	{
		return this.getId()+this.getName()+this.getRace();
	}
}
