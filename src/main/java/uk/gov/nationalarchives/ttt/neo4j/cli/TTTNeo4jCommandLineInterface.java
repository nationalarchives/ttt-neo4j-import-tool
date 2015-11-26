package uk.gov.nationalarchives.ttt.neo4j.cli;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uk.gov.nationalarchives.ttt.neo4j.service.LinkService;
import uk.gov.nationalarchives.ttt.neo4j.service.PersonGraphService;

import java.util.Arrays;

/**
 * Created by jcharlet on 11/25/15.
 */
@Component
public class TTTNeo4jCommandLineInterface implements CommandLineRunner {

    final private Logger logger = LoggerFactory.getLogger(getClass());
    final private PersonGraphService personGraphService;
    final private LinkService linkService;

    public static final String OPTION_HELP = "help";
    private static final String OPTION_LIMIT = "limit";
    private static final String OPTION_SCORE_THRESHOLD = "scoreThreshold";


    public static final String OPTION_SAVE_PEOPLE = "savePeople";
    public static final String OPTION_REMOVE_PEOPLE = "removePeople";
    public static final String OPTION_COLLECTION_NAME = "collectionName";
    public static final String OPTION_SAVE_LINKS = "saveLinks";
    public static final String OPTION_REMOVE_LINKS = "removeLinks";
    public static final String OPTION_EMPTY_GRAPH_DB = "emptyGraphDb";

    @Autowired
    public TTTNeo4jCommandLineInterface(PersonGraphService personGraphService, LinkService linkService) {
        this.personGraphService = personGraphService;
        this.linkService = linkService;
    }

    @Override
    public void run(String... args) throws Exception {
        OptionParser commandLineInterfaceOptionParser = new OptionParser() {
            {
                acceptsAll(Arrays.asList("c", OPTION_COLLECTION_NAME), "input mongo collection name")
                        .withRequiredArg()
                        .ofType(String.class);
                acceptsAll(Arrays.asList("l", OPTION_LIMIT), "limit for saving person collection into graph")
                        .withRequiredArg()
                        .ofType(Integer.class);
                acceptsAll(Arrays.asList("t", OPTION_SCORE_THRESHOLD), "score threshold for saving links")
                        .withRequiredArg()
                        .ofType(Double.class).defaultsTo(0d);
                acceptsAll(Arrays.asList("p", OPTION_SAVE_PEOPLE), "save Person collection into graph");
                acceptsAll(Arrays.asList("e", OPTION_EMPTY_GRAPH_DB), "empty graph db");
                acceptsAll(Arrays.asList("l", OPTION_SAVE_LINKS), "save links from linker collection");
//                acceptsAll(Arrays.asList("rl", OPTION_REMOVE_LINKS), "remove links from linker collection");
                accepts(OPTION_HELP).forHelp();
            }
        };

        OptionSet optionSet = commandLineInterfaceOptionParser.parse(args);

        if (optionSet.has(OPTION_HELP)) {
            commandLineInterfaceOptionParser.printHelpOn(System.out);
            return;
        }


        String collectionName=null;
        if (optionSet.has(OPTION_COLLECTION_NAME)) {
            collectionName = (String) optionSet.valueOf(OPTION_COLLECTION_NAME);
        }

        Integer limit=null;
        if (optionSet.has(OPTION_LIMIT)) {
            limit = (Integer) optionSet.valueOf(OPTION_LIMIT);
        }


        Double scoreThreshold=null;
        if (optionSet.has(OPTION_SCORE_THRESHOLD)) {
            scoreThreshold = (Double) optionSet.valueOf(OPTION_SCORE_THRESHOLD);
        }else{
            scoreThreshold=0d;
        }

        if (optionSet.has(OPTION_EMPTY_GRAPH_DB)){
            logger.info("emptyGraphDatabase");
            personGraphService.emptyGraphDatabase();
        }

        if (optionSet.has(OPTION_SAVE_PEOPLE)) {
            if (collectionName==null){
                commandLineInterfaceOptionParser.printHelpOn(System.out);
                return;
            }
            personGraphService.bulkSavePeopleGraphFromMongoCollection(collectionName, limit);
        }else if (optionSet.has(OPTION_REMOVE_PEOPLE)) {
//                personGraphService.removePeopleFromCollection(collectionName);
        }else if (optionSet.has(OPTION_SAVE_LINKS)){
            Long longLimit=null;
            if(limit!=null){
                longLimit = Long.valueOf(limit);
            }
            linkService.bulkSaveLinksIntoGraphFromMongoCollection(collectionName, longLimit,scoreThreshold);
        }else if (optionSet.has(OPTION_REMOVE_LINKS)){
            logger.warn("NOT IMPLEMENTED YET");
        }
    }
}
