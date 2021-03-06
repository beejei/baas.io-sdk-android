
package com.kth.baasio.utils;

import com.kth.baasio.exception.BaasioRuntimeException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.JsonNodeFactory;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class JsonUtils {

    static ObjectMapper mapper = new ObjectMapper().configure(
            DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static String getStringProperty(Map<String, JsonNode> properties, String name) {
        JsonNode value = properties.get(name);
        if (value != null) {
            return value.asText();
        }
        return null;
    }

    public static void setStringProperty(Map<String, JsonNode> properties, String name, String value) {
        if (value == null) {
            properties.remove(name);
        } else {
            properties.put(name, JsonNodeFactory.instance.textNode(value));
        }
    }

    public static Long getLongProperty(Map<String, JsonNode> properties, String name) {
        JsonNode value = properties.get(name);
        if (value != null) {
            return value.asLong(0);
        }
        return null;
    }

    public static void setLongProperty(Map<String, JsonNode> properties, String name, Long value) {
        if (value == null) {
            properties.remove(name);
        } else {
            properties.put(name, JsonNodeFactory.instance.numberNode(value));
        }
    }

    public static void setFloatProperty(Map<String, JsonNode> properties, String name, Float value) {
        if (value == null) {
            properties.remove(name);
        } else {
            properties.put(name, JsonNodeFactory.instance.numberNode(value));
        }
    }

    public static Boolean getBooleanProperty(Map<String, JsonNode> properties, String name) {
        JsonNode value = properties.get(name);
        if (value != null) {
            return value.asBoolean();
        }
        return null;
    }

    public static void setBooleanProperty(Map<String, JsonNode> properties, String name,
            Boolean value) {
        if (value == null) {
            properties.remove(name);
        } else {
            properties.put(name, JsonNodeFactory.instance.booleanNode(value));
        }
    }

    public static UUID getUUIDProperty(Map<String, JsonNode> properties, String name) {
        JsonNode value = properties.get(name);
        if (value != null) {
            UUID uuid = null;
            try {
                uuid = UUID.fromString(value.asText());
            } catch (Exception e) {
            }
            return uuid;
        }
        return null;
    }

    public static void setUUIDProperty(Map<String, JsonNode> properties, String name, UUID value) {
        if (value == null) {
            properties.remove(name);
        } else {
            properties.put(name, JsonNodeFactory.instance.textNode(value.toString()));
        }
    }

    public static String toJsonString(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonGenerationException e) {
            throw new BaasioRuntimeException("Unable to generate json", e);
        } catch (JsonMappingException e) {
            throw new BaasioRuntimeException("Unable to map json", e);
        } catch (IOException e) {
            throw new BaasioRuntimeException("IO error", e);
        }
    }

    public static <T> T parse(String json, Class<T> c) {
        try {
            return mapper.readValue(json, c);
        } catch (JsonGenerationException e) {
            throw new BaasioRuntimeException("Unable to generate json", e);
        } catch (JsonMappingException e) {
            throw new BaasioRuntimeException("Unable to map json", e);
        } catch (IOException e) {
            throw new BaasioRuntimeException("IO error", e);
        }
    }

    public static JsonNode toJsonNode(Object obj) {
        return mapper.convertValue(obj, JsonNode.class);
    }

    public static <T> T fromJsonNode(JsonNode json, Class<T> c) {
        try {
            return mapper.readValue(json, c);
        } catch (JsonGenerationException e) {
            throw new BaasioRuntimeException("Unable to generate json", e);
        } catch (JsonMappingException e) {
            throw new BaasioRuntimeException("Unable to map json", e);
        } catch (IOException e) {
            throw new BaasioRuntimeException("IO error", e);
        }
    }

    public static <T> T fromJsonString(String jsonString, Class<T> c) {
        try {
            return mapper.readValue(jsonString, c);
        } catch (JsonGenerationException e) {
            throw new BaasioRuntimeException("Unable to generate json", e);
        } catch (JsonMappingException e) {
            throw new BaasioRuntimeException("Unable to map json", e);
        } catch (IOException e) {
            throw new BaasioRuntimeException("IO error", e);
        }
    }

    public static <T> T getObjectProperty(Map<String, JsonNode> properties, String name, Class<T> c) {
        JsonNode value = properties.get(name);
        if (value != null) {
            return fromJsonNode(value, c);
        }
        return null;
    }

    public static void setObjectProperty(Map<String, JsonNode> properties, String name, Object value) {
        if (value == null) {
            properties.remove(name);
        } else {
            properties.put(name, JsonNodeFactory.instance.textNode(value.toString()));
        }
    }

}
