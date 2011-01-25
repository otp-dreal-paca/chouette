package fr.certu.chouette.manager;

import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fr.certu.chouette.common.ChouetteException;
import fr.certu.chouette.core.CoreException;
import fr.certu.chouette.filter.DetailLevelEnum;
import fr.certu.chouette.filter.Filter;
import fr.certu.chouette.model.neptune.NeptuneIdentifiedObject;
@ContextConfiguration(locations={"classpath:ChouetteContext.xml"})
public abstract class AbstractNoDaoManagerTests<T extends NeptuneIdentifiedObject> extends AbstractManagerTests<T>
{

	
    @BeforeMethod (groups = { "noDao" } , dependsOnMethods="createManager")
    public void initNoDao()
    {
    	manager.setDao(null);
    }
	
	@Test(groups = { "noDao" }, expectedExceptions={CoreException.class} , description = "manager should report no dao available")
	public void verifyGetWithoutDao() throws ChouetteException
	{
		manager.get(null, Filter.getNewEmptyFilter(), DetailLevelEnum.ATTRIBUTE);
		assert false;  //shouldn't be invoked
	}

	@Test(groups = { "noDao" }, expectedExceptions={CoreException.class} , description = "manager should report no dao available")
	public void verifyGetAllWithoutDao() throws ChouetteException
	{
		manager.getAll(null, Filter.getNewEmptyFilter(), DetailLevelEnum.ATTRIBUTE);
		assert false;  //shouldn't be invoked
	}

	@Test(groups = { "noDao" }, expectedExceptions={CoreException.class}, description = "manager should report no dao available")
	public void verifyAddNewWithoutDao() throws ChouetteException
	{
		manager.setDao(null);
		manager.addNew(null, bean);
		assert false;  //shouldn't be invoked
	}

	@Test(groups = { "noDao" }, expectedExceptions={CoreException.class}, description = "manager should report no dao available" )
	public void verifyUpdateWithoutDao() throws ChouetteException
	{
		manager.setDao(null);
		manager.update(null, bean);
		assert false;  //shouldn't be invoked
	}

	@Test(groups = { "noDao" }, expectedExceptions={CoreException.class}, description = "manager should report no dao available" )
	public void verifyRemoveWithoutDao() throws ChouetteException
	{
		manager.setDao(null);
		manager.remove(null, bean);
		assert false;  //shouldn't be invoked
	}

	@Test(groups = { "noDao" }, expectedExceptions={CoreException.class}, description = "manager should report no dao available" )
	public void verifyRemoveAllWithoutDao() throws ChouetteException
	{
		manager.setDao(null);
		Filter filter = Filter.getNewEqualsFilter("id", Long.valueOf(0));
		manager.removeAll(null, filter);
		assert false;  //shouldn't be invoked
	}


}
