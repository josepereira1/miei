ents_rel_fl.txt: reliquia_freeling.txt
	grep NP reliquia_freeling.txt | cut -f1,3 -d' ' > ents_rel_fl.txt

ents_rel_xcent.txt: reliquia_fix.txt
	./xcent -c reliquia_fix.txt > ents_rel_xcent.txt

ents_xcent_noclass.txt: ents_rel_xcent.txt
	grep -v ':t' ents_rel_xcent.txt | sed 's/:\w//g;s/ /_/g' > ents_xcent_noclass.txt

ents_fl_noclass.txt: ents_rel_fl.txt
	cut -f1 -d' ' ents_rel_fl.txt > ents_fl_noclass.txt

ents_diff.txt: ents_fl_noclass.txt ents_xcent_noclass.txt
	- diff -y ents_xcent_noclass.txt ents_fl_noclass.txt > ents_diff.txt