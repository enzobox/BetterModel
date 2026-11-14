# BoxMC fork of BetterModel

Branch `folia-26.2` = upstream tag `3.5.0` (what BoxMC production ran) + upstream PR #468
"fix: preserve hitbox packet conversion until client removal" (commit `2a383c21`, merged upstream as
`f92f9bb4` on 2026-11-03, after the 3.6.0 release), cherry-picked unchanged. Version stamp `3.5.0-boxmc.1`.

Why: BoxMC BUG-0696. A hitbox armour stand removed before its first data update leaked the raw
`set_entity_data` field 9 (health 20.0, Float) to clients that had been told it was an item display
(field 9 = Integer interpolation duration) -> client "Network Protocol Error" disconnect near crab,
pest and turkey models.

Build: `./gradlew :platform:paper:shadowJar` (JDK 25). Deployed under the upstream file name
`bettermodel-3.5.0-paper.jar` so the server's update folder replaces it; ops manifest `ports/PORTS.tsv`.
Drop this fork once an upstream release contains #468 (check its changelog first).
