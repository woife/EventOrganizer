package template_input;

public class TemplateDesc {
	
	private String	Filepath;
	private String	Description;
	private Boolean	valid;
	
	public TemplateDesc()
	{
		valid = false;
	}	
	
	public TemplateDesc( String Filepath, String Description )
	{
		this.Filepath		= Filepath;
		this.Description	= Description;
		
		valid = true;
	}
	
	public void SetFilepath( String Filepath )
	{
		this.Filepath = Filepath;
	}
	
	public void SetDescription( String Description )
	{
		this.Description = Description;
	}
	
	public void SetValid( Boolean valid )
	{
		this.valid = valid;
	}
	
	public String GetFilepath()
	{
		return Filepath;
	}
	
	public String GetDescription()
	{
		return Description;
	}
	
	public Boolean IsValid()
	{
		return valid;
	}
}
