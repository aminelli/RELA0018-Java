package com.corso.samples.advanced;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Advanced demo on Java Serialization.
 *
 * <p>
 * Covers default serialization, transient fields, custom writeObject/readObject,
 * serialVersionUID, Externalizable, readResolve, and deserialization filters.
 * </p>
 */
public final class SerializationAdvancedDemo {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String YELLOW = "\u001B[33m";

    private SerializationAdvancedDemo() {
    }

    /**
     * Entry-point della demo.
     */
    public static void run() {
        printHeader("ADVANCED SERIALIZATION IN JAVA");

        demoDefaultSerialization();
        demoTransientFields();
        demoCustomWriteReadObject();
        demoSerialVersionUidImportance();
        demoExternalizable();
        demoReadResolveSingleton();
        demoDeserializationFilter();
        demoBestPracticesAndAntiPatterns();

        printFooter();
    }

    /**
     * Mostra serializzazione/deserializzazione standard di oggetti Serializable.
     */
    private static void demoDefaultSerialization() {
        printSection("1) Default Serialization");

        CustomerRecord customer = new CustomerRecord("C-001", "Alice", LocalDate.of(1990, 7, 14));
        byte[] payload = serialize(customer);
        CustomerRecord restored = deserialize(payload, CustomerRecord.class);

        System.out.println("Original -> " + customer);
        System.out.println("Restored -> " + restored);
        System.out.println("Payload bytes -> " + payload.length);
    }

    /**
     * Mostra come i campi transient vengano esclusi dal flusso serializzato.
     */
    private static void demoTransientFields() {
        printSection("2) Transient Fields");

        SessionContext context = new SessionContext("token-abc", "ADMIN", "secret-value");
        byte[] payload = serialize(context);
        SessionContext restored = deserialize(payload, SessionContext.class);

        // Il campo transient viene azzerato al valore di default (null),
        // quindi va ricostruito o ricaricato dopo la deserializzazione.
        System.out.println("Original session -> " + context);
        System.out.println("Restored session -> " + restored);
    }

    /**
     * Mostra customizzazione del protocollo con writeObject/readObject.
     */
    private static void demoCustomWriteReadObject() {
        printSection("3) Custom writeObject/readObject");

        SecuredAccount account = new SecuredAccount("ACC-42", "mario.rossi", "mypass123");
        byte[] payload = serialize(account);
        SecuredAccount restored = deserialize(payload, SecuredAccount.class);

        // In questo esempio serializziamo la password in forma "offuscata"
        // e la ripristiniamo durante la lettura.
        System.out.println("Original account -> " + account);
        System.out.println("Restored account -> " + restored);
    }

    /**
     * Spiega il ruolo del serialVersionUID per compatibilità tra versioni.
     */
    private static void demoSerialVersionUidImportance() {
        printSection("4) serialVersionUID");

        // serialVersionUID identifica in modo univoco la versione serializzata della classe.
        // Cambi strutturali non compatibili richiedono gestione esplicita della compatibilità.
        System.out.println("CustomerRecord serialVersionUID = " + CustomerRecord.serialVersionUID);
        System.out.println("SessionContext serialVersionUID = " + SessionContext.serialVersionUID);
        System.out.println("SecuredAccount serialVersionUID = " + SecuredAccount.serialVersionUID);
    }

    /**
     * Mostra il controllo completo del formato serializzato con Externalizable.
     */
    private static void demoExternalizable() {
        printSection("5) Externalizable");

        ExternalOrder order = new ExternalOrder(1001, List.of("keyboard", "mouse", "monitor"));
        byte[] payload = serialize(order);
        ExternalOrder restored = deserialize(payload, ExternalOrder.class);

        System.out.println("Original external order -> " + order);
        System.out.println("Restored external order -> " + restored);
    }

    /**
     * Mostra come readResolve preserva invarianti (es. singleton).
     */
    private static void demoReadResolveSingleton() {
        printSection("6) readResolve for Singleton-like invariants");

        AppConfiguration original = AppConfiguration.INSTANCE;
        byte[] payload = serialize(original);
        AppConfiguration restored = deserialize(payload, AppConfiguration.class);

        System.out.println("Original instance hash -> " + System.identityHashCode(original));
        System.out.println("Restored instance hash -> " + System.identityHashCode(restored));
        System.out.println("Same instance after readResolve -> " + (original == restored));
    }

    /**
     * Mostra uso di ObjectInputFilter per limitare rischio in deserializzazione.
     */
    private static void demoDeserializationFilter() {
        printSection("7) Deserialization Filter (Security)");

        CustomerRecord customer = new CustomerRecord("C-007", "Eve", LocalDate.of(1987, 4, 1));
        byte[] payload = serialize(customer);

        try {
            CustomerRecord restored = deserializeWithFilter(payload, CustomerRecord.class,
                    "maxdepth=5;maxrefs=20;com.corso.samples.generated.SerializationAdvancedDemo$CustomerRecord;!*" );
            System.out.println("Filtered restored customer -> " + restored);
        } catch (RuntimeException exception) {
            System.out.println("Filtered deserialization blocked: " + exception.getMessage());
        }
    }

    /**
     * Riepilogo di pratiche consigliate e anti-pattern comuni.
     */
    private static void demoBestPracticesAndAntiPatterns() {
        printSection("8) Best Practices and Anti-Patterns");

        String[] practices = {
                "Define explicit serialVersionUID on every Serializable class.",
                "Use transient for secrets and rehydrate sensitive state after restore.",
                "Prefer custom writeObject/readObject only when there is clear need.",
                "Use ObjectInputFilter to constrain deserialization inputs.",
                "Validate object invariants inside readObject/readResolve.",
                "Consider JSON/Protobuf for cross-system contracts and versioning." };

        for (int i = 0; i < practices.length; i++) {
            System.out.printf("%d) %s%n", i + 1, practices[i]);
        }

        printSubSection("Common anti-patterns");
        System.out.println("- Deserializing untrusted bytes without filters");
        System.out.println("- Storing credentials in non-transient fields");
        System.out.println("- Breaking compatibility without serialVersionUID strategy");
        System.out.println("- Swallowing InvalidObjectException and continuing with corrupted state");
    }

    /**
     * Serializza oggetto in byte array.
     */
    private static byte[] serialize(Object object) {
        Objects.requireNonNull(object, "object must not be null");

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException exception) {
            throw new RuntimeException("Serialization error: " + exception.getMessage(), exception);
        }
    }

    /**
     * Deserializza byte array in oggetto tipizzato.
     */
    private static <T> T deserialize(byte[] payload, Class<T> targetType) {
        Objects.requireNonNull(payload, "payload must not be null");
        Objects.requireNonNull(targetType, "targetType must not be null");

        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(payload);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {

            Object object = objectInputStream.readObject();
            return targetType.cast(object);
        } catch (IOException | ClassNotFoundException exception) {
            throw new RuntimeException("Deserialization error: " + exception.getMessage(), exception);
        }
    }

    /**
     * Deserializza applicando un ObjectInputFilter di sicurezza.
     */
    private static <T> T deserializeWithFilter(byte[] payload, Class<T> targetType, String filterPattern) {
        Objects.requireNonNull(payload, "payload must not be null");
        Objects.requireNonNull(targetType, "targetType must not be null");
        Objects.requireNonNull(filterPattern, "filterPattern must not be null");

        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(payload);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {

            ObjectInputFilter filter = ObjectInputFilter.Config.createFilter(filterPattern);
            objectInputStream.setObjectInputFilter(filter);

            Object object = objectInputStream.readObject();
            return targetType.cast(object);
        } catch (IOException | ClassNotFoundException exception) {
            throw new RuntimeException("Filtered deserialization error: " + exception.getMessage(), exception);
        }
    }

    /**
     * Rendering header.
     */
    private static void printHeader(String title) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(CYAN + "=".repeat(95) + RESET);
        System.out.println(BLUE + " " + title + RESET);
        System.out.println(CYAN + "=".repeat(95) + RESET);
    }

    /**
     * Rendering sezione principale.
     */
    private static void printSection(String title) {
        System.out.println();
        System.out.println(MAGENTA + "► " + title + RESET);
        System.out.println(YELLOW + "-".repeat(95) + RESET);
    }

    /**
     * Rendering sotto-sezione.
     */
    private static void printSubSection(String title) {
        System.out.println();
        System.out.println(CYAN + "  • " + title + RESET);
    }

    /**
     * Rendering footer.
     */
    private static void printFooter() {
        System.out.println();
        System.out.println(GREEN + "Demo completed: advanced serialization scenarios executed." + RESET);
        System.out.println(CYAN + "=".repeat(95) + RESET);
    }

    /**
     * Classe Serializable base.
     */
    public static class CustomerRecord implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String customerId;
        private final String name;
        private final LocalDate birthDate;

        public CustomerRecord(String customerId, String name, LocalDate birthDate) {
            this.customerId = customerId;
            this.name = name;
            this.birthDate = birthDate;
        }

        @Override
        public String toString() {
            return "CustomerRecord{id='" + customerId + "', name='" + name + "', birthDate=" + birthDate + "}";
        }
    }

    /**
     * Serializable con campo transient.
     */
    public static class SessionContext implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String sessionId;
        private final String role;
        private transient String secret;

        public SessionContext(String sessionId, String role, String secret) {
            this.sessionId = sessionId;
            this.role = role;
            this.secret = secret;
        }

        @Override
        public String toString() {
            return "SessionContext{sessionId='" + sessionId + "', role='" + role + "', secret='" + secret + "'}";
        }
    }

    /**
     * Serializable con protocollo custom writeObject/readObject.
     */
    public static class SecuredAccount implements Serializable {
        private static final long serialVersionUID = 1L;

        private final String accountId;
        private final String username;
        private String password;

        public SecuredAccount(String accountId, String username, String password) {
            this.accountId = accountId;
            this.username = username;
            this.password = password;
        }

        private void writeObject(ObjectOutputStream outputStream) throws IOException {
            // defaultWriteObject serializza i campi non transient in modo standard.
            outputStream.defaultWriteObject();

            // Serializziamo una forma "protetta" della password per scopi demo.
            String encoded = new StringBuilder(password).reverse().toString();
            outputStream.writeUTF(encoded);
        }

        private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
            inputStream.defaultReadObject();

            String encoded = inputStream.readUTF();
            this.password = new StringBuilder(encoded).reverse().toString();

            if (password.isBlank()) {
                throw new InvalidObjectException("password must not be blank after deserialization");
            }
        }

        @Override
        public String toString() {
            return "SecuredAccount{accountId='" + accountId + "', username='" + username
                    + "', password='" + password + "'}";
        }
    }

    /**
     * Externalizable: pieno controllo su formato e ordine dei campi.
     */
    public static class ExternalOrder implements Externalizable {
        private static final long serialVersionUID = 1L;

        private int orderId;
        private List<String> items;

        public ExternalOrder() {
            // Costruttore pubblico obbligatorio per Externalizable.
            this.items = new ArrayList<>();
        }

        public ExternalOrder(int orderId, List<String> items) {
            this.orderId = orderId;
            this.items = new ArrayList<>(items);
        }

        @Override
        public void writeExternal(ObjectOutput output) throws IOException {
            output.writeInt(orderId);
            output.writeInt(items.size());
            for (String item : items) {
                output.writeUTF(item);
            }
        }

        @Override
        public void readExternal(ObjectInput input) throws IOException {
            this.orderId = input.readInt();
            int size = input.readInt();
            this.items = new ArrayList<>(size);
            for (int index = 0; index < size; index++) {
                this.items.add(input.readUTF());
            }
        }

        @Override
        public String toString() {
            return "ExternalOrder{orderId=" + orderId + ", items=" + items + "}";
        }
    }

    /**
     * Enum singleton serializzabile: readResolve preserva l'unicità istanza.
     */
    public enum AppConfiguration {
        INSTANCE;

        private Object readResolve() {
            return INSTANCE;
        }
    }
}