package load;

public class LoaderFactory {

	public ILoader createLoader(String delimiter,  String path){
		return new Loader(delimiter, path);
	}
	
}
