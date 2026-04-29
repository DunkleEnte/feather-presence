# feather-presence

A lightweight Minecraft server plugin for integrating Feather Client's Rich Presence.

## Requirements
- Paper 1.21+
- [FeatherServerAPI](https://github.com/FeatherMC/feather-server-api/releases)

## Installation

1. Drop `feather-presence.jar` into your `plugins/` folder.
2. Restart the server.
3. Edit `plugins/feather-presence/config.yml` to your liking.
4. Run `/feather-admin refresh`.

## Configuration

```yaml
presence:
  imageUrl: paste-your-image-url-in
  imageText: hover-text
  state: current-state
  details: footer
messages:
  success: <#8DFB08>Success <#CACACA>⏵ <white>You successfully reloaded the plugin!
  noPermission: <#FF0000>Error <#CACACA>⏵ <white>You don't have permission to use
    this command.
  wrongUsage: <#FF0000>Error <#CACACA>⏵ <white>Wrong Usage!

```

## Example
<img width="1014" height="319" alt="image" src="https://github.com/user-attachments/assets/9b8ba2e5-0f23-4655-8056-fa3c0da02984" />

## Color Formats
mod-detection is using MiniMessage for colors, if you don't know how to use it feel free to
checkout this website -> https://docs.papermc.io/adventure/minimessage/

| Format | Example |
|---|---|
| MiniMessage | `<red>`, `<bold>`, `<#FF0000>` |
| MiniMessage gradient | `<gradient:#FF0000:#00FF00>text</gradient>` |

## Permissions

| Permission | Description | Default |
|---|---|---|
| `feather.admin` | Access to admin messages & `/feather-admin refresh`  | op |

## Commands

| Command | Description | Permission |
|---|---|---|
| `/feather-admin refresh` | Reloads the config | `feather.admin` 
```
