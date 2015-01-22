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

Adding a `cljs.edn` file fixes the issue. When no `cljs.edn` file is present
it is generated and will [load all cljs namespaces](https://github.com/adzerk/boot-cljs/blob/master/src/adzerk/boot_cljs.clj#L77-L78).
I assume that one of the then loaded namespaces causes the issue.
(That's triggered by Reagent and `reload` is surprising still.)

Also compiling with `:pseudo-names true` fixes it but that's not
really an acceptable solution.
