MSG="auto-commit"

cm:
	git add -A 
	git commit -m ${MSG}
	git push
