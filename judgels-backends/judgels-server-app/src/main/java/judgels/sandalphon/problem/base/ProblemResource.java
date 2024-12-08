package judgels.sandalphon.problem.base;

import static judgels.service.ServiceUtils.checkFound;

import io.dropwizard.hibernate.UnitOfWork;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import judgels.sandalphon.problem.base.editorial.ProblemEditorialStore;
import judgels.sandalphon.problem.base.statement.ProblemStatementStore;
import judgels.service.ServiceUtils;

@Path("/api/v2/problems/{problemJid}")
public class ProblemResource {
    private final ProblemStore problemStore;
    private final ProblemStatementStore statementStore;
    private final ProblemEditorialStore editorialStore;

    @Inject
    public ProblemResource(ProblemStore problemStore, ProblemStatementStore statementStore, ProblemEditorialStore editorialStore) {
        this.problemStore = problemStore;
        this.statementStore = statementStore;
        this.editorialStore = editorialStore;
    }

    @GET
    @Path("/render/{mediaFilename}")
    @UnitOfWork
    public Response renderStatementMediaFile(
            @HeaderParam("If-Modified-Since") Optional<String> ifModifiedSince,
            @PathParam("problemJid") String problemJid,
            @PathParam("mediaFilename") String mediaFilename) {

        checkFound(problemStore.getProblemByJid(problemJid));
        String mediaUrl = statementStore.getStatementMediaFileURL(null, problemJid, mediaFilename);

        return ServiceUtils.buildMediaResponse(mediaUrl, ifModifiedSince);
    }

    @GET
    @Path("/editorials/render/{mediaFilename}")
    @UnitOfWork
    public Response renderEditorialMediaFile(
            @HeaderParam("If-Modified-Since") Optional<String> ifModifiedSince,
            @PathParam("problemJid") String problemJid,
            @PathParam("mediaFilename") String mediaFilename) {

        checkFound(problemStore.getProblemByJid(problemJid));
        String mediaUrl = editorialStore.getEditorialMediaFileURL(null, problemJid, mediaFilename);

        return ServiceUtils.buildMediaResponse(mediaUrl, ifModifiedSince);
    }
}
