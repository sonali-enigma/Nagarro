package tshirts;

public class Tshirt {

	private String ID;  
    private String Name;
    private String Colour;
    private String Gender;
    private String Size;
    private float Rating;
    private float Price;
    private String Availability;

    public Tshirt(){}

    public Tshirt(String ID, String Name, String Colour, String Gender,String Size,float Price,float Rating,String Availability) {
    	
        this.ID = ID;
        this.Name = Name;
        this.Colour = Colour;
        this.Gender = Gender;
        this.Size = Size;
        this.Price = Price;
        this.Rating = Rating;
        this.Availability = Availability;
        
    }

    public String getID()
    {
        return ID;
    }
    public void setID(String ID)
    {
    	 this.ID = ID;
    }

    public String getName()
    {
        return Name;
    }
    public void setName(String Name)
    {
    	  this.Name = Name;
    }

    public String getColour()
    {
        return  Colour;
    }
    public void setColour(String Colour)
    {
    	this.Colour = Colour;
    }
    
    public String getGender()
    {
        return Gender;
    }
    public void setGender(String Gender)
    {
        this.Gender=Gender;
    }

    public String getSize()
    {
        return Size;
    }
    public void setSize(String Size)
    {
        this.Size=Size;
    }

    public float getPrice()
    {
        return Price;
    }
    public void setPrice(float Price)
    {
    	 this.Price = Price;
    }
    
    public float getRating()
    {
        return Rating;
    }
    public void setRating(float Rating)
    {
        this.Rating=Rating;
    }
    
    public String getAvailability()
    {
        return Availability;
    }
    public void setAvailability(String Availability)
    {
        this.Availability=Availability;
    }

   
}
