import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features="src/test/java",
        strict = true )
public class RunCukesTest {
}
