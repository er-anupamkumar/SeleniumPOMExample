package pages;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CallWS {

    private void checkIfRestAPI(Object object) {
        if (Objects.isNull(object)) {
            throw new RuntimeException("The object to verify is null");
        }
        Class<?> clazz = object.getClass();
        if (!clazz.isAnnotationPresent(pages.RestAPI.class)) {
            throw new RuntimeException("The class "
                    + clazz.getSimpleName()
                    + " is not annotated with RestAPI");
        }
    }

    public String prepareRequestBody(Object object) throws Exception {
        checkIfRestAPI(object);
        Class<?> clazz = object.getClass();
        pages.RestAPI restAPI = object.getClass().getAnnotation(pages.RestAPI.class);
        System.out.println("ResourcePath:"+ restAPI.resourcePath());
        System.out.println("HttpMethod:"+ restAPI.httpMethod());
        Map<String, String> jsonElementsMap = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(pages.ReqParam.class)) {
                jsonElementsMap.put(getJsonPath(field), (String) field.get(object));
            }
        }
        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\""
                        + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }

    private String getJsonPath(Field field) {
        String value = field.getAnnotation(pages.ReqParam.class)
                .jsonPath();
        return value.isEmpty() ? field.getName() : value;
    }

    public void sendRequest(Object object) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        checkIfRestAPI(object);
        Class<?> clazz = object.getClass();
        System.out.println(clazz.getDeclaredMethods().length);
        System.out.println(clazz.getMethods().length);
        for (Method method : clazz.getMethods()) {
            System.out.println(method.getName());
        }
        Method method = clazz.getMethod("getRequest");
        String reqB = method.invoke(object).toString();
        System.out.println("in Sedn methid > "+reqB);
        Method method2 = clazz.getMethod("setResponse", String.class);
        method2.invoke(object,"State OK");
    }

}
