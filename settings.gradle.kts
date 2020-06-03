include(":feature:analytics")
rootProject.name="Chaser"
include(":app",
    ":feature:cigarette", ":feature:analytics",
    ":data:repository-impl", ":data:repository",
    "data:localdatasource-impl", ":data:localdatasource",
    ":core:android", ":core:resources", ":core:model"
)
