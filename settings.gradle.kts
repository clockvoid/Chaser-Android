
rootProject.name="Chaser"

include(":app",
    ":feature:cigarette", ":feature:caffeine", ":feature:alcohol",
    ":components:setting", ":components:license",
    ":data:repository-impl", ":data:repository",
    "data:localdatasource-impl", ":data:localdatasource",
    ":core:android", ":core:resources", ":core:model"
)
