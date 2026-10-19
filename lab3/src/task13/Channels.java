package src.task13;

import java.util.Map;
import java.util.function.Supplier;

// единственное место, где строка конфигурации превращается в объект
public final class Channels {
    private static final Map<String, Supplier<Channel>> BY_TYPE = Map.of(
            "email", () -> new EmailChannel("noreply@coursehub"),
            "sms", () -> new SmsChannel(20),
            "push", PushChannel::new);

    private Channels() {
    }

    public static Channel byType(String type) {
        Supplier<Channel> factory = BY_TYPE.get(type);
        if (factory == null) throw new IllegalArgumentException("unknown type " + type);
        return factory.get();
    }
}
