package error;

public class PlotNotFound extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PlotNotFound(Long id){
		super("Could not find plot");
	}
	
}
