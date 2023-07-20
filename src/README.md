## Bukkit Redis Interface

This project aims to bring a unified Redis API
to minecraft servers. Most of the common lifecycle events
of a server are broadcast to the redis channel. You can hook
into the API with your own plugin to publish custom events
and listen to them. This allows for minecraft servers to scale
way beyond their traditional minecraft platform by for instance
connecting it to discord bots or websites.