package domCreator;

import java.util.ArrayList;

import domain.NaturalDisaster;

public class DomainCreatorFactory {
	
	public IDomainCreator createDomainCreator(String delimiter, String path){
		return new DomainCreator(delimiter, path);
	}

}
