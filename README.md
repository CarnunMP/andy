# andy

Little [babashka](https://babashka.org) script for opening a random https://notes.andymatuschak.org note.

### usage

The script is globally available, like so:

```bash
$ bb .bb/andy.clj

# or, after `chmod a+x .bb/andy.clj`, just:
$ .bb/andy.clj
```

This is thanks to a symlink from `.bb/andy.clj` to `./bin/andy.clj`.

### Updating

Because the script is based on a [linkchecker](https://linkchecker.github.io/linkchecker/) dump, it might now be out of date.

To update it, create a new dump with `linkchecker https://notes.andymatuschak.org/ -F csv -v -q` or similar and replace `resources/andy.csv`. Then re-run the file-writing scratch in [src/andy.clj](src/andy.clj).
