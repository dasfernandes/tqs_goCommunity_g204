import { CreatecampaignModule } from './createcampaign.module';

describe('CreatecampaignModule', () => {
  let createcampaignModule: CreatecampaignModule;

  beforeEach(() => {
    createcampaignModule = new CreatecampaignModule();
  });

  it('should create an instance', () => {
    expect(createcampaignModule).toBeTruthy();
  });
});
