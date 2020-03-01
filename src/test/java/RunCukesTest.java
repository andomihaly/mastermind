import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target\\cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features="src/test/java",
        //tags = "@notest",
        //tags = "@smoke",
        //tags = "@quicktest",
        //tags = "@smoke and @quicktest",
        //tags = "not @quicktest",
        //tags = "not @quicktest and not @smoke",
        strict = true
        )
public class RunCukesTest {
}
