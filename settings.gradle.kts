include()
rootProject.name="Chaser"
include(":app",
    ":feature:cigarette", ":feature:analytics", ":feature:alcohol",
    ":data:repository-impl", ":data:repository",
    "data:localdatasource-impl", ":data:localdatasource",
    ":core:android", ":core:resources", ":core:model"
)
