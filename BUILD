load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name="java-maven-lib",
    srcs = glob(["src/main/java/com/example/demo/*.java"]),
    deps = [
        "@maven//:com_indico_indico_client_java",
        "@maven//:com_google_code_gson_gson",
        ],
)

filegroup(
    name = "config",
    srcs = glob(["*.properties"]),
)

java_binary(
    name = "app",
    main_class = "com.example.demo.App",
    runtime_deps=[":java-maven-lib"],
    data =["//:config"]
)

