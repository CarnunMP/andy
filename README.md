# andy

Little [babashka](https://babashka.org) script for opening a random https://notes.andymatuschak.org note.

### usage

Clone this repo _somewhere_ on your machine. Then (if you like) make the script globally available with a symlink:

```bash
ln -s ~/<somewhere>/andy/bin/andy.clj .bb/andy.clj
## or `mklink ...` or whatever the Windows equivalent is 😅
```

Now:

```bash
bb .bb/andy.clj
# opening https://notes.andymatuschak.org/z5FKgZAnMhS73t9kenbVUYx23CHSQAE1gKxVf

## or, after `chmod a+x .bb/andy.clj`, just:
.bb/andy.clj
# opening https://notes.andymatuschak.org/z3wZ7ebhYtWDJS2cSgoER2nZwMz2Zpc2pVAYz
```

### Updating

Because the script is based on a [linkchecker](https://linkchecker.github.io/linkchecker/) dump, it might now be out of date.

To update it, create a new dump with `linkchecker https://notes.andymatuschak.org/ -F csv -v -q` or similar and replace `resources/andy.csv`. Then re-run the file-writing scratch in [src/andy.clj](src/andy.clj).
