## Wierd pseudo-names error:

To reproduce:

**This breaks** with `TypeError: undefined is not a function (evaluating '(void 0)()')`:

```
boot from-cljsjs reload cljs -O advanced -c "{:pseudo-names false}"
```

after removing the `reload` task it works:

```
boot from-cljsjs cljs -O advanced -c "{:pseudo-names false}"
```

equally it works if you remove Reagent (not that `reload` task is used):

```
mv src/cljs/test_app/app.cljs reagent.cljs
mv simple-ns.cljs src/cljs/test_app/app.cljs
boot reload cljs -O advanced -c "{:pseudo-names false}"
```

(Restore original state: `git checkout simple-ns.cljs src/; rm reagent.cljs`)

### Fixes

Adding a `cljs.edn` file fixes the issue. I assume since then not
all .cljs namespaces are loaded anymore.

Also compiling with `:pseudo-names true` fixes it but that's not
really an acceptable solution.
