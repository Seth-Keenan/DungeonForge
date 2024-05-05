import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CharacterCreatorTest.class, CharacterFileTest.class, CharacterTest.class, DisplayTest.class })
public class AllTests {
	
}
