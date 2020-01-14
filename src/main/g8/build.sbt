
lazy val documentation = (project in file("."))
  .enablePlugins(ParadoxMaterialThemePlugin)
  .enablePlugins(ParadoxSitePlugin)
  .settings(
    name := "$name$",
    publish / skip := true,
    // add dependencies if needed
    // libraryDependencies += "com.example" %% "example-lib-scala" % "1.0.0",
    // configure material theme color
    Compile / paradoxMaterialTheme ~= {
      _.withColor("teal", "indigo")
    },
    // exclude includes folder
    (Compile / paradoxMarkdownToHtml / excludeFilter) :=
      (Compile / paradoxMarkdownToHtml / excludeFilter).value ||
        ParadoxPlugin.InDirectoryFilter((Compile / paradox / sourceDirectory).value / "includes")
  )