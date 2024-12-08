package judgels.gabriel.isolate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.nio.file.Path;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableIsolateConfiguration.class)
public interface IsolateConfiguration {
    Path getBaseDir();

    class Builder extends ImmutableIsolateConfiguration.Builder {}
}
